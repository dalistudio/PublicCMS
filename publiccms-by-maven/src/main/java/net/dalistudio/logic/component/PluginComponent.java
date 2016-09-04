package net.dalistudio.logic.component;

import static java.util.Collections.synchronizedList;
import static java.util.Collections.synchronizedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.spi.Cacheable;
import net.dalistudio.common.spi.Pluginable;
import net.dalistudio.entities.plugin.PluginSite;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.plugin.PluginSiteService;
import com.wangdali.common.base.Base;

@Component
public class PluginComponent extends Base implements Cacheable {
    private Map<String, Pluginable> pluginMap = new HashMap<String, Pluginable>();
    private static List<Integer> cachedlist = synchronizedList(new ArrayList<Integer>());
    private static Map<Integer, Map<String, String>> cachedMap = synchronizedMap(new HashMap<Integer, Map<String, String>>());

    @Autowired
    public void init(List<Pluginable> widgetList) {
        for (Pluginable plugin : widgetList) {
            if (notEmpty(plugin.getCode())) {
                pluginMap.put(plugin.getCode(), plugin);
            }
        }
    }

    public String handle(SysSite site, String content) {
        Map<String, String> siteMap = cachedMap.get(site.getId());
        if (empty(siteMap)) {
            siteMap = new HashMap<String, String>();
            @SuppressWarnings("unchecked")
            List<PluginSite> list = (List<PluginSite>) pluginSiteService.getPage(site.getId(), null, null, null).getList();
            for (PluginSite pluginSite : list) {
                Pluginable plugin = pluginMap.get(pluginSite.getPluginCode());
                if (notEmpty(plugin) && plugin.supportWidget()) {
                    siteMap.put(pluginSite.getPluginCode(), pluginSite.getWidgetTemplate());
                }
            }
            cachedlist.add(site.getId());
            cachedMap.put(site.getId(), siteMap);
        }

        return content;
    }

    public void removeCache(int siteId) {
        cachedlist.remove(cachedlist.indexOf(siteId));
        cachedMap.remove(siteId);
    }

    @Autowired
    private PluginSiteService pluginSiteService;

    @Override
    public void clear() {
        cachedlist.clear();
        cachedMap.clear();
    }
}