package net.dalistudio.views.directive.plugin;

// Generated 2016-3-3 17:43:26 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.plugin.PluginVote;
import net.dalistudio.logic.service.plugin.PluginVoteService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class PluginVoteDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        if (notEmpty(id)) {
            handler.put("object", service.getEntity(id)).render();
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<PluginVote> entityList = service.getEntitys(ids);
                Map<String, PluginVote> map = new LinkedHashMap<String, PluginVote>();
                for (PluginVote entity : entityList) {
                    map.put(String.valueOf(entity.getId()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private PluginVoteService service;

}
