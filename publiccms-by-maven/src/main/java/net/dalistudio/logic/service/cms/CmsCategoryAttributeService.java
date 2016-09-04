package net.dalistudio.logic.service.cms;

// Generated 2015-5-8 16:50:23 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.cms.CmsCategoryAttribute;
import net.dalistudio.logic.dao.cms.CmsCategoryAttributeDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class CmsCategoryAttributeService extends BaseService<CmsCategoryAttribute> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer pageIndex, Integer pageSize) {
        return dao.getPage(pageIndex, pageSize);
    }

    public void updateAttribute(Integer categoryId, CmsCategoryAttribute entity) {
        CmsCategoryAttribute attribute = getEntity(categoryId);
        if (notEmpty(attribute)) {
            if (notEmpty(entity)) {
                update(attribute.getCategoryId(), entity, new String[] { "categoryId" });
            } else {
                delete(attribute.getCategoryId());
            }
        } else {
            entity.setCategoryId(categoryId);
            save(entity);
        }
    }

    @Autowired
    private CmsCategoryAttributeDao dao;
}