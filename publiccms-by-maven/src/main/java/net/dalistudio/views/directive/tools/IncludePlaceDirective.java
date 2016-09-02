package net.dalistudio.views.directive.tools;

import static net.dalistudio.logic.component.TemplateComponent.INCLUDE_DIRECTORY;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.component.MetadataComponent;
import net.dalistudio.logic.component.TemplateComponent;
import net.dalistudio.views.pojo.CmsPlaceMetadata;
import com.wangdali.common.handler.RenderHandler;

@Component
public class IncludePlaceDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        String path = handler.getString("path");
        if (notEmpty(path)) {
            SysSite site = getSite(handler);
            CmsPlaceMetadata metadata = metadataComponent.getPlaceMetadata(siteComponent.getWebTemplateFilePath(site,
                    INCLUDE_DIRECTORY + path));
            if (site.isUseSsi()) {
                handler.print("<!--#include virtual=\"/" + INCLUDE_DIRECTORY + path + "\"-->");
            } else {
                handler.print(templateComponent.printPlace(site, path, metadata));
            }
        }
    }
    
    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private TemplateComponent templateComponent;
    @Autowired
    private MetadataComponent metadataComponent;
}
