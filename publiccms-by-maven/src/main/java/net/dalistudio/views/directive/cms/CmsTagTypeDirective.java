package net.dalistudio.views.directive.cms;

// Generated 2015-7-10 16:36:23 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.cms.CmsTagType;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.cms.CmsTagTypeService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class CmsTagTypeDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        SysSite site = getSite(handler);
        if (notEmpty(id)) {
            CmsTagType entity = service.getEntity(id);
            if (notEmpty(entity) && site.getId() == entity.getSiteId()) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<CmsTagType> entityList = service.getEntitys(ids);
                Map<String, CmsTagType> map = new LinkedHashMap<String, CmsTagType>();
                for (CmsTagType entity : entityList) {
                    if (site.getId() == entity.getSiteId()) {
                        map.put(String.valueOf(entity.getId()), entity);
                    }
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private CmsTagTypeService service;

}
