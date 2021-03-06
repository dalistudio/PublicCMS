package net.dalistudio.views.directive.sys;

// Generated 2015-7-22 13:48:39 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.sys.SysRoleMoudle;
import net.dalistudio.logic.service.sys.SysRoleMoudleService;
import net.dalistudio.logic.service.sys.SysRoleService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysRoleMoudleDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer[] roleIds = handler.getIntegerArray("roleIds");
        Integer moudleId = handler.getInteger("moudleId");
        if (notEmpty(roleIds)) {
            if (notEmpty(moudleId)) {
                SysRoleMoudle entity = service.getEntity(roleIds, moudleId);
                handler.put("object", entity).render();
            } else {
                Integer[] moudleIds = handler.getIntegerArray("moudleIds");
                if (notEmpty(moudleIds)) {
                    Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
                    if (sysRoleService.showAllMoudle(roleIds)) {
                        for (Integer id : moudleIds) {
                            map.put(String.valueOf(id), true);
                        }
                    } else {
                        for (SysRoleMoudle entity : service.getEntitys(roleIds, moudleIds)) {
                            map.put(String.valueOf(entity.getMoudleId()), true);
                        }
                    }
                    handler.put("map", map).render();
                }
            }
        }
    }

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMoudleService service;

}