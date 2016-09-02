package net.dalistudio.views.directive.sys;

// Generated 2016-1-20 11:19:18 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.sys.SysDomain;
import net.dalistudio.logic.service.sys.SysDomainService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysDomainDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        if (notEmpty(id)) {
            SysDomain entity = service.getEntity(id);
            if (notEmpty(entity)) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<SysDomain> entityList = service.getEntitys(ids);
                Map<String, SysDomain> map = new LinkedHashMap<String, SysDomain>();
                for (SysDomain entity : entityList) {
                    map.put(String.valueOf(entity.getName()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private SysDomainService service;

}
