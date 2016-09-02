package net.dalistudio.common.view.web;

import static net.dalistudio.common.base.AbstractController.getUserFromSession;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.dalistudio.common.view.InitializeFreeMarkerView;

/**
 * 
 * WebFreeMarkerView 视图类
 *
 */
public class WebFreeMarkerView extends InitializeFreeMarkerView {
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        model.put(CONTEXT_USER, getUserFromSession(request.getSession()));
        super.exposeHelpers(model, request);
    }
}