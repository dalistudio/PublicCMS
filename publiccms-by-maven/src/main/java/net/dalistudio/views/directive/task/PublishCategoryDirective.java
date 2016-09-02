package net.dalistudio.views.directive.task;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTaskDirective;
import net.dalistudio.entities.cms.CmsCategory;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.component.TemplateComponent;
import net.dalistudio.logic.service.cms.CmsCategoryService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class PublishCategoryDirective extends AbstractTaskDirective {
    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        Integer pageIndex = handler.getInteger("pageIndex");
        Integer totalPage = handler.getInteger("totalPage");
        SysSite site = getSite(handler);
        Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
        if (notEmpty(id)) {
            CmsCategory entity = service.getEntity(id);
            map.put(entity.getId().toString(), deal(site, entity, pageIndex, totalPage));
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<CmsCategory> entityList = service.getEntitys(ids);
                for (CmsCategory entity : entityList) {
                    map.put(entity.getId().toString(), deal(site, entity, pageIndex, totalPage));
                }
            }
        }
        handler.put("map", map).render();
    }

    private boolean deal(SysSite site, CmsCategory entity, Integer pageIndex, Integer totalPage) {
        if (notEmpty(entity)) {
            return templateComponent.createCategoryFile(site, entity, pageIndex, totalPage);
        }
        return false;
    }

    @Autowired
    private TemplateComponent templateComponent;
    @Autowired
    private CmsCategoryService service;
}
