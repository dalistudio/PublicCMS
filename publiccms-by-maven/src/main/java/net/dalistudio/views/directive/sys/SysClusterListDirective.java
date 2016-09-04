package net.dalistudio.views.directive.sys;

// Generated 2016-7-16 11:56:50 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.sys.SysClusterService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;
import com.wangdali.common.handler.PageHandler;

@Component
public class SysClusterListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(handler.getDate("startHeartbeatDate"), handler.getDate("endHeartbeatDate"), handler.getBoolean("master"), 
                handler.getString("orderField"), handler.getString("orderType"), handler.getInteger("pageIndex",1), handler.getInteger("count",30));
        handler.put("page", page).render();
    }

    @Autowired
    private SysClusterService service;

}