package net.dalistudio.views.directive.sys;

import static net.dalistudio.common.tools.ExtendUtils.getExtendMap;

// Generated 2016-7-16 11:54:15 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.sys.SysConfig;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.sys.SysConfigService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class SysConfigDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        String code = handler.getString("code");
        String subcode = handler.getString("subcode");
        SysSite site = getSite(handler);
        if (notEmpty(code) && notEmpty(subcode)) {
            SysConfig entity = service.getEntity(site.getId(), code, subcode);
            if (notEmpty(entity)) {
                handler.put("object", getExtendMap(entity.getData())).render();
            }
        }
    }

    @Autowired
    private SysConfigService service;

}
