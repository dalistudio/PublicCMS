package net.dalistudio.views.controller.admin.sys;

// Generated 2016-3-1 17:24:12 by com.wangdali.common.source.SourceMaker

import static com.wangdali.common.tools.RequestUtils.getIpAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.dalistudio.common.base.AbstractController;
import net.dalistudio.entities.log.LogOperate;
import net.dalistudio.entities.sys.SysAppClient;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.logic.service.sys.SysAppClientService;

@Controller
@RequestMapping("sysAppClient")
public class SysAppClientAdminController extends AbstractController {
    @Autowired
    private SysAppClientService service;

    @RequestMapping(value = "enable", method = RequestMethod.POST)
    public String enable(Long id, HttpServletRequest request, HttpSession session, ModelMap model) {
        SysAppClient entity = service.getEntity(id);
        if (notEmpty(entity.getId())) {
            SysSite site = getSite(request);
            if (verifyNotEquals("siteId", site.getId(), entity.getSiteId(), model)) {
                return TEMPLATE_ERROR;
            }
            service.updateStatus(id, false);
            logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(),
                    LogLoginService.CHANNEL_WEB_MANAGER, "enable.appclient", getIpAddress(request), getDate(), id + ":"
                            + entity.getUuid()));
        }
        return TEMPLATE_DONE;
    }

    @RequestMapping(value = "disable", method = RequestMethod.POST)
    public String disable(Long id, HttpServletRequest request, HttpSession session, ModelMap model) {
        SysAppClient entity = service.getEntity(id);
        if (notEmpty(entity)) {
            SysSite site = getSite(request);
            if (verifyNotEquals("siteId", site.getId(), entity.getSiteId(), model)) {
                return TEMPLATE_ERROR;
            }
            service.updateStatus(id, true);
            logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(),
                    LogLoginService.CHANNEL_WEB_MANAGER, "disable.appclient", getIpAddress(request), getDate(), id + ":"
                            + entity.getUuid()));
        }
        return TEMPLATE_DONE;
    }
}