package net.dalistudio.views.directive.sys;

// Generated 2016-2-15 21:14:47 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.sys.SysFtpUser;
import net.dalistudio.logic.service.sys.SysFtpUserService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysFtpUserDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        if (notEmpty(id)) {
            SysFtpUser entity = service.getEntity(id);
            if (notEmpty(entity)) {
                handler.put("object", entity).render();
            }
        } else {
            Integer[] ids = handler.getIntegerArray("ids");
            if (notEmpty(ids)) {
                List<SysFtpUser> entityList = service.getEntitys(ids);
                Map<String, SysFtpUser> map = new LinkedHashMap<String, SysFtpUser>();
                for (SysFtpUser entity : entityList) {
                    map.put(String.valueOf(entity.getId()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private SysFtpUserService service;

}
