package net.dalistudio.views.directive.sys;

// Generated 2015-7-20 11:46:39 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.sys.SysApp;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.sys.SysAppService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysAppDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        SysSite site = getSite(handler);
        if (notEmpty(id)) {
            SysApp entity = service.getEntity(id);
            if (notEmpty(entity) && site.getId() == entity.getSiteId()) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<SysApp> entityList = service.getEntitys(ids);
                Map<String, SysApp> map = new LinkedHashMap<String, SysApp>();
                for (SysApp entity : entityList) {
                    if(site.getId() == entity.getSiteId()){
                        map.put(String.valueOf(entity.getId()), entity);
                    }
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private SysAppService service;

}
