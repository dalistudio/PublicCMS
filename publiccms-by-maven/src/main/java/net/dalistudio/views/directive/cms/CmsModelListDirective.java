package net.dalistudio.views.directive.cms;

// Generated 2015-5-10 17:54:56 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.cms.CmsModelService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.RenderHandler;

@Component
public class CmsModelListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Boolean disabled = false;
        if (handler.getBoolean("advanced", false)) {
            disabled = handler.getBoolean("disabled", false);
        }
        PageHandler page = service.getPage(getSite(handler).getId(), handler.getInteger("parentId"),
                handler.getBoolean("hasChild"), handler.getBoolean("onlyUrl"), handler.getBoolean("hasImages"),
                handler.getBoolean("hasFiles"), disabled, handler.getInteger("pageIndex"), handler.getInteger("count"));
        handler.put("page", page).render();
    }

    @Autowired
    private CmsModelService service;

}