package net.dalistudio.views.controller.admin.plugin;

// Generated 2016-3-1 17:24:24 by com.wangdali.common.source.SourceMaker

import static com.wangdali.common.tools.RequestUtils.getIpAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dalistudio.common.base.AbstractController;
import net.dalistudio.entities.log.LogOperate;
import net.dalistudio.entities.plugin.PluginSite;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.logic.service.plugin.PluginSiteService;

@Controller
@RequestMapping("pluginSite")
public class PluginSiteAdminController extends AbstractController {
    @Autowired
    private PluginSiteService service;

    @RequestMapping("save")
    public String save(PluginSite entity, HttpServletRequest request, HttpSession session, ModelMap model) {
        SysSite site = getSite(request);
        if (notEmpty(entity.getId())) {
            PluginSite oldEntity = service.getEntity(entity.getId());
            if (empty(oldEntity) || verifyNotEquals("siteId", site.getId(), oldEntity.getSiteId(), model)) {
                return TEMPLATE_ERROR;
            }
            entity = service.update(entity.getId(), entity, new String[] { "id", "siteId", "pluginCode" });
            if (notEmpty(entity)) {
                logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(),
                        LogLoginService.CHANNEL_WEB_MANAGER, "update.plugin.site", getIpAddress(request), getDate(), "plugin:"
                                + entity.getPluginCode()));
            }
        } else {
            entity.setSiteId(site.getId());
            service.save(entity);
            logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(),
                    LogLoginService.CHANNEL_WEB_MANAGER, "save.plugin.site", getIpAddress(request), getDate(), "plugin:"
                            + entity.getPluginCode()));
        }
        return TEMPLATE_DONE;
    }

    @RequestMapping("delete")
    public String delete(String pluginCode, HttpServletRequest request, HttpSession session) {
        SysSite site = getSite(request);
        service.delete(site.getId(), pluginCode);
        logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(), LogLoginService.CHANNEL_WEB_MANAGER,
                "delete.plugin.site", getIpAddress(request), getDate(), "plugin:" + pluginCode));
        return TEMPLATE_DONE;
    }
}