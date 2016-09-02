package net.dalistudio.views.directive.log;

// Generated 2015-7-3 16:15:25 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.log.LogTask;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.log.LogTaskService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class LogTaskDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Long id = handler.getLong("id");
        SysSite site = getSite(handler);
        if (notEmpty(id)) {
            LogTask entity = service.getEntity(id);
            if (notEmpty(entity) && site.getId() == entity.getSiteId()) {
                handler.put("object", entity).render();
            }
        } else {
            Long[] ids = handler.getLongArray("ids");
            if (notEmpty(ids)) {
                List<LogTask> entityList = service.getEntitys(ids);
                Map<String, LogTask> map = new LinkedHashMap<String, LogTask>();
                for (LogTask entity : entityList) {
                    if (site.getId() == entity.getSiteId()) {
                        map.put(String.valueOf(entity.getId()), entity);
                    }
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private LogTaskService service;

}