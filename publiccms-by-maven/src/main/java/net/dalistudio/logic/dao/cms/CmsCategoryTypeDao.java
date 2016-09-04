package net.dalistudio.logic.dao.cms;

// Generated 2016-2-26 15:57:04 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.cms.CmsCategoryType;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class CmsCategoryTypeDao extends BaseDao<CmsCategoryType> {
    public PageHandler getPage(Integer siteId, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsCategoryType bean");
        if (notEmpty(siteId)) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        }
        queryHandler.order("bean.sort asc,bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected CmsCategoryType init(CmsCategoryType entity) {
        return entity;
    }

}