package net.dalistudio.views.directive.cms;

// Generated 2016-2-26 15:57:04 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.cms.CmsCategoryType;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.cms.CmsCategoryTypeService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class CmsCategoryTypeDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        SysSite site = getSite(handler);
        if (notEmpty(id)) {
            CmsCategoryType entity = service.getEntity(id);
            if (notEmpty(entity) && site.getId() == entity.getSiteId()) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<CmsCategoryType> entityList = service.getEntitys(ids);
                Map<String, CmsCategoryType> map = new LinkedHashMap<String, CmsCategoryType>();
                for (CmsCategoryType entity : entityList) {
                    if(site.getId() == entity.getSiteId()){
                        map.put(String.valueOf(entity.getId()), entity);
                    }
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private CmsCategoryTypeService service;

}
