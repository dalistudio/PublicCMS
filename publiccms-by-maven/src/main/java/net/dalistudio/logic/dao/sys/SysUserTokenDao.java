package net.dalistudio.logic.dao.sys;

// Generated 2016-1-20 11:19:18 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysUserToken;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysUserTokenDao extends BaseDao<SysUserToken> {
    public PageHandler getPage(Integer siteId, Long userId, String channel, String orderType, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysUserToken bean");
        if (notEmpty(siteId)) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        }
        if (notEmpty(userId)) {
            queryHandler.condition("bean.userId = :userId").setParameter("userId", userId);
        }
        if (notEmpty(channel)) {
            queryHandler.condition("bean.channel = :channel").setParameter("channel", channel);
        }
        if ("asc".equalsIgnoreCase(orderType)) {
            orderType = "asc";
        } else {
            orderType = "desc";
        }
        queryHandler.order("bean.createDate " + orderType + ",bean.id " + orderType);
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected SysUserToken init(SysUserToken entity) {
        if (empty(entity.getCreateDate())) {
            entity.setCreateDate(getDate());
        }
        return entity;
    }

}