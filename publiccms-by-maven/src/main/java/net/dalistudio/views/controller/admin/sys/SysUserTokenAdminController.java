package net.dalistudio.views.controller.admin.sys;

// Generated 2016-1-20 11:19:18 by com.wangdali.common.source.SourceMaker

import static com.wangdali.common.tools.RequestUtils.getIpAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dalistudio.common.base.AbstractController;
import net.dalistudio.entities.log.LogOperate;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.entities.sys.SysUserToken;
import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.logic.service.sys.SysUserTokenService;

@Controller
@RequestMapping("sysUserToken")
public class SysUserTokenAdminController extends AbstractController {

    @RequestMapping("delete")
    public String delete(String authToken, HttpServletRequest request, HttpSession session, ModelMap model) {
        SysSite site = getSite(request);
        SysUserToken entity = service.getEntity(authToken);
        Long userId = getAdminFromSession(session).getId();
        if (notEmpty(entity)) {
            if (verifyNotEquals("siteId", userId, entity.getUserId(), model)) {
                return TEMPLATE_ERROR;
            }
            service.delete(authToken);
            logOperateService.save(new LogOperate(site.getId(), userId, LogLoginService.CHANNEL_WEB_MANAGER, "delete.ftpuser",
                    getIpAddress(request), getDate(), entity.getAuthToken() + " channel:" + entity.getChannel() + " ip:"
                            + entity.getLoginIp()));
        }
        return TEMPLATE_DONE;
    }

    @Autowired
    private SysUserTokenService service;

}