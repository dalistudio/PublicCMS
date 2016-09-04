package net.dalistudio.views.directive.tools;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.logic.component.FileComponent;
import com.wangdali.common.handler.RenderHandler;

@Component
public class TaskTemplateContentDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        String path = handler.getString("path");
        if (notEmpty(path)) {
            handler.put("object", fileComponent.getFileContent(siteComponent.getTaskTemplateFilePath(getSite(handler), path)))
                    .render();
        }
    }
    
    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private FileComponent fileComponent;
}
