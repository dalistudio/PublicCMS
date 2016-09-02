package net.dalistudio.logic.dao.cms;

// Generated 2015-5-8 16:50:23 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.cms.CmsContentAttribute;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class CmsContentAttributeDao extends BaseDao<CmsContentAttribute> {
    public PageHandler getPage(Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsContentAttribute bean");
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected CmsContentAttribute init(CmsContentAttribute entity) {
        if (empty(entity.getSource())) {
            entity.setSource(null);
        }
        if (empty(entity.getSourceUrl())) {
            entity.setSourceUrl(null);
        }
        return entity;
    }

}