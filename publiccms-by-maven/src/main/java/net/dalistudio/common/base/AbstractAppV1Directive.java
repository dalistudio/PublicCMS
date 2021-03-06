package net.dalistudio.common.base;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import net.dalistudio.common.base.app.AppV1;
import net.dalistudio.entities.sys.SysApp;
import net.dalistudio.entities.sys.SysAppToken;
import net.dalistudio.entities.sys.SysUser;
import net.dalistudio.entities.sys.SysUserToken;
import net.dalistudio.logic.service.sys.SysAppService;
import net.dalistudio.logic.service.sys.SysAppTokenService;
import net.dalistudio.logic.service.sys.SysUserService;
import net.dalistudio.logic.service.sys.SysUserTokenService;
import com.wangdali.common.handler.RenderHandler;

/**
 * 
 * BaseDirective 自定义接口指令基类
 *
 */
public abstract class AbstractAppV1Directive extends AbstractAppDirective implements AppV1 {
    public final static String REQUIRED_PARAMTER = "required_paramter:";
    private SysUser getUser(RenderHandler handler) throws Exception {
        String authToken = handler.getString("authToken");
        Long authUserId = handler.getLong("authUserId");
        if (notEmpty(authToken) && notEmpty(authUserId)) {
            SysUserToken sysUserToken = sysUserTokenService.getEntity(authToken);
            if (notEmpty(sysUserToken) && sysUserToken.getUserId() == authUserId) {
                return sysUserService.getEntity(sysUserToken.getUserId());
            }
        }
        return null;
    }

    /*
     * 获得应用
     */
    private SysApp getApp(RenderHandler handler) throws Exception {
        SysAppToken appToken = appTokenService.getEntity(handler.getString("appToken"));
        if (notEmpty(appToken)) {
            return appService.getEntity(appToken.getAppId());
        }
        return null;
    }

    /*
     * 执行
     */
    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        SysApp app = null;
        SysUser user = null;
        if (needAppToken() && empty((app = getApp(handler)))) {
            handler.put("error", "needAppToken").render();
        } else if (needUserToken() && empty((user = getUser(handler)))) {
            handler.put("error", "needLogin").render();
        } else {
            execute(handler, app, user);
        }
    }

    public abstract void execute(RenderHandler handler, SysApp app, SysUser user) throws IOException, Exception;

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Autowired
    private SysAppTokenService appTokenService;
    @Autowired
    private SysAppService appService;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Autowired
    private SysUserService sysUserService;
}
