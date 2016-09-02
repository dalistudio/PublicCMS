package net.dalistudio.logic.service.cms;

import java.io.Serializable;
import java.util.Collection;

// Generated 2016-3-22 11:21:35 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.cms.CmsWord;
import net.dalistudio.logic.dao.cms.CmsWordDao;
import net.dalistudio.views.pojo.CmsWordStatistics;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class CmsWordService extends BaseService<CmsWord> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, Boolean hidden, Date startCreateDate, Date endCreateDate, String name,
            String orderField, String orderType, Integer pageIndex, Integer pageSize) {
        return dao.getPage(siteId, hidden, startCreateDate, endCreateDate, name, orderField, orderType, pageIndex, pageSize);
    }

    public void updateStatistics(Collection<CmsWordStatistics> entitys) {
        for (CmsWordStatistics entityStatistics : entitys) {
            CmsWord entity = getEntity(entityStatistics.getId());
            if (notEmpty(entity)) {
                entity.setSearchCount(entity.getSearchCount() + entityStatistics.getSearchCounts());
            }
        }
    }

    public CmsWord getEntity(int siteId, String name) {
        return dao.getEntity(siteId, name);
    }

    public CmsWord updateStatus(Serializable id, boolean status) {
        CmsWord entity = dao.getEntity(id);
        if (notEmpty(entity)) {
            entity.setHidden(status);
        }
        return entity;
    }

    @Autowired
    private CmsWordDao dao;
}