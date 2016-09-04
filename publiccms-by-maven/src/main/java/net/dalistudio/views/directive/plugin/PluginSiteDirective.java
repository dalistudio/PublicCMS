package net.dalistudio.views.directive.plugin;

// Generated 2016-3-1 17:24:24 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.plugin.PluginSite;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.plugin.PluginSiteService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class PluginSiteDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        String pluginCode = handler.getString("pluginCode");
        SysSite site = getSite(handler);
        if (notEmpty(pluginCode)) {
            handler.put("object", service.getEntity(site.getId(), pluginCode)).render();
        } else {
            String[] pluginCodes = handler.getStringArray("pluginCodes");
            if (notEmpty(pluginCodes)) {
                List<PluginSite> entityList = service.getEntitys(site.getId(), pluginCodes);
                Map<String, PluginSite> map = new LinkedHashMap<String, PluginSite>();
                for (PluginSite entity : entityList) {
                    map.put(entity.getPluginCode(), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private PluginSiteService service;

}
