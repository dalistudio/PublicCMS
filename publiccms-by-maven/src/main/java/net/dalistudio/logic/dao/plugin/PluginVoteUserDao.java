package net.dalistudio.logic.dao.plugin;

// Generated 2016-3-3 17:46:06 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.plugin.PluginVoteUser;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class PluginVoteUserDao extends BaseDao<PluginVoteUser> {
    public PageHandler getPage(Integer lotteryId, Long userId, 
                String ip, Date startCreateDate, Date endCreateDate, 
                String orderType, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from PluginVoteUser bean");
        if (notEmpty(lotteryId)) {
            queryHandler.condition("bean.lotteryId = :lotteryId").setParameter("lotteryId", lotteryId);
        }
        if (notEmpty(userId)) {
            queryHandler.condition("bean.userId = :userId").setParameter("userId", userId);
        }
        if (notEmpty(ip)) {
            queryHandler.condition("bean.ip = :ip").setParameter("ip", ip);
        }
        if (notEmpty(startCreateDate)) {
            queryHandler.condition("bean.createDate > :startCreateDate").setParameter("startCreateDate", startCreateDate);
        }
        if (notEmpty(endCreateDate)) {
            queryHandler.condition("bean.createDate <= :endCreateDate").setParameter("endCreateDate", endCreateDate);
        }
        if("asc".equalsIgnoreCase(orderType)){
            orderType = "asc";
        }else{
            orderType = "desc";
        }
        queryHandler.order("bean.createDate " + orderType);
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected PluginVoteUser init(PluginVoteUser entity) {
        return entity;
    }

}