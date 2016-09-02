package net.dalistudio.common.base;

import static net.dalistudio.logic.component.SiteComponent.CONTEXT_SITE;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import net.dalistudio.entities.sys.SysApp;
import net.dalistudio.entities.sys.SysAppToken;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.component.SiteComponent;
import net.dalistudio.logic.service.sys.SysAppService;
import net.dalistudio.logic.service.sys.SysAppTokenService;
import com.wangdali.common.directive.BaseTemplateDirective;
import com.wangdali.common.directive.HttpDirective;
import com.wangdali.common.handler.HttpParameterHandler;
import com.wangdali.common.handler.RenderHandler;

/**
 * 
 * AbstractTemplateDirective 自定义模板指令基类
 *
 */
public abstract class AbstractTemplateDirective extends BaseTemplateDirective implements HttpDirective {
    public SysSite getSite(RenderHandler handler) throws Exception {
        return (SysSite) handler.getAttribute(CONTEXT_SITE);
    }

    @Override
    public void execute(HttpMessageConverter<Object> httpMessageConverter, MediaType mediaType, HttpServletRequest request,
            String callback, HttpServletResponse response) throws IOException, Exception {
        HttpParameterHandler handler = new HttpParameterHandler(httpMessageConverter, mediaType, request, callback, response);
        if (needAppToken() && empty(getApp(handler))) {
            handler.put("error", "needAppToken").render();
        } else {
            execute(handler);
            handler.render();
        }
    }

    private SysApp getApp(RenderHandler handler) throws Exception {
        SysAppToken appToken = appTokenService.getEntity(handler.getString("appToken"));
        if (notEmpty(appToken)) {
            return appService.getEntity(appToken.getAppId());
        }
        return null;
    }

    public boolean needAppToken() {
        return false;
    }

    @Autowired
    private SysAppTokenService appTokenService;
    @Autowired
    private SysAppService appService;
    @Autowired
    protected SiteComponent siteComponent;
}