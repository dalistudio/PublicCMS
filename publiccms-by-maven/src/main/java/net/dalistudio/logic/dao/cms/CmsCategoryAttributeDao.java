package net.dalistudio.logic.dao.cms;

// Generated 2016-1-19 11:41:45 by com.wangdali.common.source.SourceMaker


import org.springframework.stereotype.Repository;

import net.dalistudio.entities.cms.CmsCategoryAttribute;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class CmsCategoryAttributeDao extends BaseDao<CmsCategoryAttribute> {
    public PageHandler getPage(Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsCategoryAttribute bean");
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected CmsCategoryAttribute init(CmsCategoryAttribute entity) {
        return entity;
    }

}