package net.dalistudio.views.controller.admin.cms;

// Generated 2016-1-27 21:06:08 by com.wangdali.common.source.SourceMaker

import static com.wangdali.common.tools.RequestUtils.getIpAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dalistudio.common.base.AbstractController;
import net.dalistudio.entities.log.LogOperate;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.logic.service.sys.SysSiteService;

@Controller
@RequestMapping("cmsSite")
public class CmsSiteAdminController extends AbstractController {
    @Autowired
    private SysSiteService service;

    @RequestMapping("save")
    public String save(SysSite entity, HttpServletRequest request, HttpSession session) {
        SysSite site = getSite(request);
        entity = service.update(site.getId(), entity, new String[] { "id", "useStatic", "useSsi", "disabled" });
        logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(),
                LogLoginService.CHANNEL_WEB_MANAGER, "update.site", getIpAddress(request), getDate(), entity.getId() + ":"
                        + entity.getName()));
        siteComponent.clear();
        return TEMPLATE_DONE;
    }
}