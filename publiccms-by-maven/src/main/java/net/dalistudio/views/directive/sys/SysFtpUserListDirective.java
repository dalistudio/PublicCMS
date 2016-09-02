package net.dalistudio.views.directive.sys;

// Generated 2016-2-15 21:14:48 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.service.sys.SysFtpUserService;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;
import com.wangdali.common.handler.PageHandler;

@Component
public class SysFtpUserListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer siteId = getSite(handler).getId();
        if (handler.getBoolean("advanced", false) && notEmpty(handler.getInteger("siteId"))) {
            siteId = handler.getInteger("siteId");
        }
        PageHandler page = service.getPage(siteId, handler.getInteger("name"), handler.getInteger("pageIndex", 1),
                handler.getInteger("count", 30));
        handler.put("page", page).render();
    }

    @Autowired
    private SysFtpUserService service;

}