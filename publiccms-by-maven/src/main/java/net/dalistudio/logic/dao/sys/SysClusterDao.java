package net.dalistudio.logic.dao.sys;

// Generated 2016-7-16 11:56:50 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysCluster;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysClusterDao extends BaseDao<SysCluster> {
    public PageHandler getPage(Date startHeartbeatDate, Date endHeartbeatDate, Boolean master, 
                String orderField, String orderType, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysCluster bean");
        if (notEmpty(startHeartbeatDate)) {
            queryHandler.condition("bean.heartbeatDate > :startHeartbeatDate").setParameter("startHeartbeatDate", startHeartbeatDate);
        }
        if (notEmpty(endHeartbeatDate)) {
            queryHandler.condition("bean.heartbeatDate <= :endHeartbeatDate").setParameter("endHeartbeatDate", endHeartbeatDate);
        }
        if (notEmpty(master)) {
            queryHandler.condition("bean.master = :master").setParameter("master", master);
        }
        if("asc".equalsIgnoreCase(orderType)){
            orderType = "asc";
        }else{
            orderType = "desc";
        }
        if(null == orderField){
            orderField="";
        }
        switch(orderField) {
            case "createDate" : queryHandler.order("bean.createDate " + orderType); break;
            case "heartbeatDate" : queryHandler.order("bean.heartbeatDate " + orderType); break;
            default : queryHandler.order("bean.id " + orderType);
        }
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected SysCluster init(SysCluster entity) {
        return entity;
    }

}