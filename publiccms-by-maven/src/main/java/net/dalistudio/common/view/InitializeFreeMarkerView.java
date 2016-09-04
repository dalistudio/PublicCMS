package net.dalistudio.common.view;

import static net.dalistudio.logic.component.SiteComponent.expose;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import net.dalistudio.logic.component.SiteComponent;

/**
 * 
 * InitializeFreeMarkerView
 *
 */
public class InitializeFreeMarkerView extends FreeMarkerView {
    protected static final String CONTEXT_ADMIN = "admin"; //管理员
    protected static final String CONTEXT_USER = "user"; // 用户
    public static SiteComponent siteComponent; // 网站组件

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        expose(model, siteComponent.getSite(request.getServerName(), request.getServerPort()), request.getScheme(),
                request.getServerName(), request.getServerPort(), request.getContextPath());
        super.exposeHelpers(model, request);
    }
}