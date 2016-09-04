package net.dalistudio.views.directive.task;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTaskDirective;
import net.dalistudio.logic.service.cms.CmsContentService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class IndexContentDirective extends AbstractTaskDirective {
    @Autowired
    private CmsContentService service;

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Long id = handler.getLong("id");
        Long[] ids = handler.getLongArray("ids");
        if (notEmpty(ids)) {
            service.index(getSite(handler).getId(), ids);
        } else if (notEmpty(id)) {
            service.index(getSite(handler).getId(), new Long[] { id });
        }
    }
}
