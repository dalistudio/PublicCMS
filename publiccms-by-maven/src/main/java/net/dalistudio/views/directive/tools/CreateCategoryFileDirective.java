package net.dalistudio.views.directive.tools;

import static net.dalistudio.logic.component.SiteComponent.getFullFileName;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTemplateDirective;
import net.dalistudio.entities.cms.CmsCategory;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.component.TemplateComponent;
import net.dalistudio.logic.service.cms.CmsCategoryService;
import com.wangdali.common.handler.RenderHandler;

import freemarker.template.TemplateException;

@Component
public class CreateCategoryFileDirective extends AbstractTemplateDirective {
    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Integer id = handler.getInteger("id");
        String templatePath = handler.getString("templatePath");
        String filePath = handler.getString("filePath");
        Integer pageIndex = handler.getInteger("pageIndex");
        if (notEmpty(id) && notEmpty(templatePath) && notEmpty(filePath)) {
            SysSite site = getSite(handler);
            try {
                CmsCategory category = categoryService.getEntity(id);
                if (notEmpty(category) && site.getId() == category.getSiteId()) {
                    handler.put(
                            "url",
                            templateComponent.createCategoryFile(site, category, getFullFileName(site, templatePath), filePath,
                                    pageIndex, null)).render();
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

}
