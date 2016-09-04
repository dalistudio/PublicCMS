package net.dalistudio.logic.dao.sys;

// Generated 2015-7-22 13:48:39 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysMoudle;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysMoudleDao extends BaseDao<SysMoudle> {
    public PageHandler getPage(Integer parentId, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysMoudle bean");
        if (notEmpty(parentId)) {
            queryHandler.condition("bean.parentId = :parentId").setParameter("parentId", parentId);
        } else {
            queryHandler.condition("bean.parentId is null");
        }
        queryHandler.order("bean.sort asc,bean.id asc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected SysMoudle init(SysMoudle entity) {
        if (empty(entity.getAuthorizedUrl())) {
            entity.setAuthorizedUrl(null);
        }
        if (empty(entity.getUrl())) {
            entity.setUrl(null);
        }
        return entity;
    }

}