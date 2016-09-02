package net.dalistudio.views.directive.sys;

// Generated 2016-1-19 11:41:45 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.sys.SysDept;
import net.dalistudio.entities.sys.SysDeptPage;
import net.dalistudio.logic.service.sys.SysDeptPageService;
import net.dalistudio.logic.service.sys.SysDeptService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysDeptPageDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer deptId = handler.getInteger("deptId");
        String page = handler.getString("page");
        if (notEmpty(deptId)) {
            if (notEmpty(page)) {
                SysDeptPage entity = service.getEntity(deptId, page);
                handler.put("object", entity).render();
            } else {
                String[] pages = handler.getStringArray("pages");
                if (notEmpty(pages)) {
                    Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
                    SysDept entity = sysDeptService.getEntity(deptId);
                    if (notEmpty(entity) && entity.isOwnsAllCategory()) {
                        for (String p : pages) {
                            map.put(p, true);
                        }
                    } else {
                        for (String p : pages) {
                            map.put(p, false);
                        }
                        for (SysDeptPage e : service.getEntitys(deptId, pages)) {
                            map.put(e.getPage(), true);
                        }
                    }
                    handler.put("map", map).render();
                }
            }
        }
    }

    @Autowired
    private SysDeptPageService service;
    @Autowired
    private SysDeptService sysDeptService;
}
