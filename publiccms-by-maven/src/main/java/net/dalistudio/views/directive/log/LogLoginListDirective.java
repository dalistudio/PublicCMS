package net.dalistudio.views.directive.log;

// Generated 2015-5-12 12:57:43 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.RenderHandler;

@Component
public class LogLoginListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(getSite(handler).getId(), handler.getLong("userId"),
                handler.getDate("startCreateDate"), handler.getDate("endCreateDate"), handler.getString("channel"),
                handler.getBoolean("result"), handler.getString("name"), handler.getString("ip"), handler.getString("orderType"),
                handler.getInteger("pageIndex", 1), handler.getInteger("count", 20));
        handler.put("page", page).render();
    }
    
    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private LogLoginService service;

}