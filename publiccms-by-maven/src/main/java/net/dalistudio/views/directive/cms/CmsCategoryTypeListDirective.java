package net.dalistudio.views.directive.cms;

// Generated 2016-2-26 15:57:04 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.logic.service.cms.CmsCategoryTypeService;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.RenderHandler;

@Component
public class CmsCategoryTypeListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service
                .getPage(getSite(handler).getId(), handler.getInteger("pageIndex"), handler.getInteger("count"));
        handler.put("page", page).render();
    }

    @Autowired
    private CmsCategoryTypeService service;

}