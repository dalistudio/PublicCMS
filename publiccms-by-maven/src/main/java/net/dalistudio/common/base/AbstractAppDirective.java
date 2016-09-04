package net.dalistudio.common.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import net.dalistudio.common.base.app.App;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.component.SiteComponent;
import com.wangdali.common.directive.BaseHttpDirective;
import com.wangdali.common.handler.RenderHandler;

/**
 * 
 * BaseDirective 自定义接口指令基类
 *
 */
public abstract class AbstractAppDirective extends BaseHttpDirective implements App {

	/*
	 * 获得网站
	 */
    public SysSite getSite(RenderHandler handler) throws IOException, Exception {
        HttpServletRequest request = handler.getRequest();
        return siteComponent.getSite(request.getServerName(), request.getServerPort());
    }

    public abstract boolean needUserToken(); // 需要用户令牌

    public abstract boolean needAppToken(); // 需要应用令牌

    @Autowired
    private SiteComponent siteComponent; // 网站组件
}
