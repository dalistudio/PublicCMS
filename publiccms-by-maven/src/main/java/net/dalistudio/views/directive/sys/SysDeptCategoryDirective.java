package net.dalistudio.views.directive.sys;

// Generated 2016-1-19 11:41:45 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.sys.SysDept;
import net.dalistudio.entities.sys.SysDeptCategory;
import net.dalistudio.logic.service.sys.SysDeptCategoryService;
import net.dalistudio.logic.service.sys.SysDeptService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysDeptCategoryDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer deptId = handler.getInteger("deptId");
        Integer categoryId = handler.getInteger("categoryId");
        if (notEmpty(deptId)) {
            if (notEmpty(categoryId)) {
                handler.put("object", service.getEntity(deptId, categoryId)).render();
            } else {
                Integer[] categoryIds = handler.getIntegerArray("categoryIds");
                if (notEmpty(categoryIds)) {
                    Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
                    SysDept entity = sysDeptService.getEntity(deptId);
                    if (notEmpty(entity)) {
                        if (entity.isOwnsAllCategory()) {
                            for (Integer id : categoryIds) {
                                map.put(String.valueOf(id), true);
                            }
                        } else {
                            for (Integer id : categoryIds) {
                                map.put(String.valueOf(id), false);
                            }
                            for (SysDeptCategory e : service.getEntitys(deptId, categoryIds)) {
                                map.put(String.valueOf(e.getCategoryId()), true);
                            }
                        }
                    }
                    handler.put("map", map).render();
                }
            }
        }
    }

    @Autowired
    private SysDeptCategoryService service;
    @Autowired
    private SysDeptService sysDeptService;
}