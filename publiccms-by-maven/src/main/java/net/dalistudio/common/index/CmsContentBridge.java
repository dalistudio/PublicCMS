package net.dalistudio.common.index;

import org.apache.lucene.document.Document;
import org.hibernate.search.bridge.FieldBridge;
import org.hibernate.search.bridge.LuceneOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.entities.cms.CmsContent;
import net.dalistudio.entities.cms.CmsContentAttribute;
import net.dalistudio.logic.service.cms.CmsContentAttributeService;
import com.wangdali.common.base.Base;

@Component
public class CmsContentBridge extends Base implements FieldBridge {
    public static CmsContentAttributeService contentAttributeService;

    @Autowired
    public void init(CmsContentAttributeService contentAttributeService) {
        CmsContentBridge.contentAttributeService = contentAttributeService;
    }

    @Override
    public void set(String name, Object value, Document document, LuceneOptions luceneOptions) {
        CmsContent content = (CmsContent) value;
        CmsContentAttribute entity = contentAttributeService.getEntity(content.getId());
        if (notEmpty(entity)) {
            content.setDescription(content.getDescription() + entity.getText());
        }
    }
}