package net.dalistudio.views.directive.cms;

// Generated 2015-5-10 17:54:56 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.cms.CmsCategoryModelService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.RenderHandler;

@Component
public class CmsCategoryModelListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(handler.getInteger("modelId"), handler.getInteger("categoryId"),
                handler.getInteger("pageIndex", 1), handler.getInteger("count"));
        handler.put("page", page).render();
    }

    @Autowired
    private CmsCategoryModelService service;

}