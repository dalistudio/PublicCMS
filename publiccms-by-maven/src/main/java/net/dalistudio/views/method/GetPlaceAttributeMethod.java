package net.dalistudio.views.method;

import static net.dalistudio.common.tools.ExtendUtils.getExtendMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.cms.CmsPlaceAttribute;
import net.dalistudio.logic.service.cms.CmsPlaceAttributeService;
import com.wangdali.common.base.BaseMethod;

import freemarker.template.TemplateModelException;

@Component
public class GetPlaceAttributeMethod extends BaseMethod {

    /*
     * (non-Javadoc)
     * 
     * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        Long id = getLong(0, arguments);
        if (notEmpty(id)) {
            CmsPlaceAttribute entity = service.getEntity(id);
            if (notEmpty(entity)) {
                return getExtendMap(entity.getData());
            }
        }
        return null;
    }

    @Autowired
    private CmsPlaceAttributeService service;
}
