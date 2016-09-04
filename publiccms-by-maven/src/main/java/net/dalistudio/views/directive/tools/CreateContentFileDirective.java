package net.dalistudio.views.directive.tools;

import static net.dalistudio.logic.component.SiteComponent.getFullFileName;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.cms.CmsCategory;
import net.dalistudio.entities.cms.CmsContent;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.component.TemplateComponent;
import net.dalistudio.logic.service.cms.CmsCategoryService;
import net.dalistudio.logic.service.cms.CmsContentService;
import com.wangdali.common.handler.RenderHandler;

import freemarker.template.TemplateException;

@Component
public class CreateContentFileDirective extends AbstractTemplateDirective {
    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Long id = handler.getLong("id");
        String templatePath = handler.getString("templatePath");
        String filePath = handler.getString("filePath");
        Integer pageIndex = handler.getInteger("pageIndex");
        if (notEmpty(id) && notEmpty(templatePath) && notEmpty(filePath)) {
            SysSite site = getSite(handler);
            String templateFullPath = getFullFileName(site, templatePath);
            try {
                CmsContent content = contentService.getEntity(id);
                if (notEmpty(content) && site.getId() == content.getSiteId()) {
                    CmsCategory category = categoryService.getEntity(content.getCategoryId());
                    handler.put(
                            "url",
                            templateComponent.createContentFile(site, content, category, false, templateFullPath, filePath,
                                    pageIndex)).render();
                }
            } catch (IOException | TemplateException e) {
                handler.print(e.getMessage());
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
    private CmsCategoryService categoryService;
    @Autowired
    private CmsContentService contentService;

}
