package net.dalistudio.views.directive.sys;

// Generated 2016-3-2 13:39:54 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.sys.SysExtendFieldService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;
import com.wangdali.common.handler.PageHandler;

@Component
public class SysExtendFieldListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(handler.getInteger("extendId"), 
                handler.getInteger("pageIndex",1), handler.getInteger("count",30));
        handler.put("page", page).render();
    }

    @Autowired
    private SysExtendFieldService service;

}