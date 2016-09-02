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

    public SysSite getSite(RenderHandler handler) throws IOException, Exception {
        HttpServletRequest request = handler.getRequest();
        return siteComponent.getSite(request.getServerName(), request.getServerPort());
    }

    public abstract boolean needUserToken();

    public abstract boolean needAppToken();

    @Autowired
    private SiteComponent siteComponent;
}
