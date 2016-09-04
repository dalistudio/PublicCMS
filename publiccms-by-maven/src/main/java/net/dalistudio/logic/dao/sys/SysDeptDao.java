package net.dalistudio.logic.dao.sys;

// Generated 2015-7-20 11:46:39 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysDept;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysDeptDao extends BaseDao<SysDept> {
    public PageHandler getPage(Integer siteId, Integer parentId, Long userId, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysDept bean");
        if (notEmpty(siteId)) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        }
        if (notEmpty(parentId)) {
            queryHandler.condition("(bean.parentId = :parentId)").setParameter("parentId", parentId);
        } else {
            queryHandler.condition("bean.parentId is null");
        }
        if (notEmpty(userId)) {
            queryHandler.condition("(bean.userId = :userId)").setParameter("userId", userId);
        }
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected SysDept init(SysDept entity) {
        return entity;
    }

}