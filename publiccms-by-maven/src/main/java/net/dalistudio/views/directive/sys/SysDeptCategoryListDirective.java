package net.dalistudio.views.directive.sys;

// Generated 2016-1-19 11:41:45 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.sys.SysDeptCategoryService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysDeptCategoryListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(handler.getInteger("deptId"), handler.getInteger("categoryId"), 
                handler.getInteger("pageIndex",1), handler.getInteger("count"));
        handler.put("page", page).render();
    }

    @Autowired
    private SysDeptCategoryService service;

}