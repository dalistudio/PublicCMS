package net.dalistudio.views.method;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.component.ConfigComponent;
import com.wangdali.common.base.BaseMethod;

import freemarker.template.TemplateModelException;

@Component
public class GetConfigCodeListMethod extends BaseMethod {

    /*
     * (non-Javadoc)
     * 
     * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
     */
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        return configComponent.getConfigCodeList();
    }

    @Autowired
    private ConfigComponent configComponent;
}
