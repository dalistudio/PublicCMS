package net.dalistudio.logic.service.cms;

// Generated 2015-5-8 16:50:23 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.cms.CmsContentAttribute;
import net.dalistudio.logic.dao.cms.CmsContentAttributeDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class CmsContentAttributeService extends BaseService<CmsContentAttribute> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer pageIndex, Integer pageSize) {
        return dao.getPage(pageIndex, pageSize);
    }

    public void updateAttribute(Long contentId, CmsContentAttribute entity) {
        CmsContentAttribute attribute = getEntity(contentId);
        if (notEmpty(attribute)) {
            if (notEmpty(entity)) {
                update(attribute.getContentId(), entity, new String[] { "contentId" });
            } else {
                delete(attribute.getContentId());
            }
        } else {
            if (notEmpty(entity)) {
                entity.setContentId(contentId);
                save(entity);
            }
        }
    }

    @Autowired
    private CmsContentAttributeDao dao;
}