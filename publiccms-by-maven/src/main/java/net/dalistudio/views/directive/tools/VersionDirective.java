package net.dalistudio.views.directive.tools;

import java.io.IOException;

import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.common.constants.CmsVersion;
import com.wangdali.common.handler.RenderHandler;

/**
 * 
 * VersionDirective 技术框架版本指令
 *
 */
@Component
public class VersionDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        handler.put("cms", CmsVersion.getVersion());
        handler.put("cluster", CmsVersion.getClusterId());
        handler.put("master", CmsVersion.isMaster());
        handler.render();
    }

}
