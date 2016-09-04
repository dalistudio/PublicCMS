package net.dalistudio.views.directive.plugin;

// Generated 2016-3-3 17:46:07 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.plugin.PluginVoteUser;
import net.dalistudio.logic.service.plugin.PluginVoteUserService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class PluginVoteUserDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Long id = handler.getLong("id");
        if (notEmpty(id)) {
            handler.put("object", service.getEntity(id)).render();
        } else {
            Long[] ids = handler.getLongArray("ids");
            if (notEmpty(ids)) {
                List<PluginVoteUser> entityList = service.getEntitys(ids);
                Map<String, PluginVoteUser> map = new LinkedHashMap<String, PluginVoteUser>();
                for (PluginVoteUser entity : entityList) {
                    map.put(String.valueOf(entity.getId()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private PluginVoteUserService service;

}
