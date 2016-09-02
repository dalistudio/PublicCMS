package net.dalistudio.views.method;

import static com.wangdali.common.tools.HTMLUtils.removeHtmlTag;

import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import com.wangdali.common.base.BaseMethod;

import freemarker.template.TemplateModelException;

@Component
public class GetTextFromHtmlMethod extends BaseMethod {
    CloseableHttpClient httpclient = HttpClients.createDefault();

    /*
     * (non-Javadoc)
     * 
     * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        String html = getString(0, arguments);
        if (notEmpty(html)) {
            return removeHtmlTag(html);
        }
        return null;
    }
}
