package net.dalistudio.views.directive.cms;

// Generated 2015-5-10 17:54:56 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.cms.CmsCategory;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.cms.CmsCategoryService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class CmsCategoryDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        SysSite site = getSite(handler);
        if (notEmpty(id)) {
            CmsCategory entity = service.getEntity(id);
            if (notEmpty(entity) && site.getId() == entity.getSiteId()) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<CmsCategory> entityList = service.getEntitys(ids);
                Map<String, CmsCategory> map = new LinkedHashMap<String, CmsCategory>();
                for (CmsCategory entity : entityList) {
                    if (site.getId() == entity.getSiteId()) {
                        map.put(String.valueOf(entity.getId()), entity);
                    }
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private CmsCategoryService service;

}
