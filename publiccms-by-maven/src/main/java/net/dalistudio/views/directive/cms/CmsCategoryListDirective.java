package net.dalistudio.views.directive.cms;

// Generated 2015-5-10 17:54:56 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.cms.CmsCategoryService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.RenderHandler;

@Component
public class CmsCategoryListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Boolean disabled = false;
        Boolean hidden = false;
        if (handler.getBoolean("advanced", false)) {
            disabled = handler.getBoolean("disabled", false);
            hidden = handler.getBoolean("hidden");
        }
        PageHandler page = service.getPage(getSite(handler).getId(), handler.getInteger("parentId"),
                handler.getInteger("typeId"), handler.getBoolean("allowContribute"), hidden, disabled,
                handler.getInteger("pageIndex", 1), handler.getInteger("count", 30));
        handler.put("page", page).render();
    }

    @Autowired
    private CmsCategoryService service;

}