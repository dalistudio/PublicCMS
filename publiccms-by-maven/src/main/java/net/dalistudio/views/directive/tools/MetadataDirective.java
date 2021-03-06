package net.dalistudio.views.directive.tools;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.logic.component.MetadataComponent;
import com.wangdali.common.handler.RenderHandler;

@Component
public class MetadataDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        String path = handler.getString("path");
        String dir = handler.getString("dir");
        if (notEmpty(path) && !path.endsWith(SEPARATOR)) {
            handler.put("object",
                            metadataComponent.getTemplateMetadata(siteComponent.getWebTemplateFilePath(getSite(handler), path)))
                    .render();
        } else if (null != dir) {
            handler.put("object", metadataComponent.getTemplateMetadataMap(siteComponent.getWebTemplateFilePath(getSite(handler), dir)))
                    .render();
        }
    }
    
    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private MetadataComponent metadataComponent;
}
