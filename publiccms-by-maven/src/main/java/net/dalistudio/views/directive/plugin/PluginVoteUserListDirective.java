package net.dalistudio.views.directive.plugin;

// Generated 2016-3-3 17:46:07 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.plugin.PluginVoteUserService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;
import com.wangdali.common.handler.PageHandler;

@Component
public class PluginVoteUserListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(handler.getInteger("lotteryId"), handler.getLong("userId"),
                handler.getString("ip"), handler.getDate("startCreateDate"), handler.getDate("endCreateDate"),
                handler.getString("orderType"), handler.getInteger("pageIndex", 1), handler.getInteger("count", 30));
        handler.put("page", page).render();
    }

    @Autowired
    private PluginVoteUserService service;

}