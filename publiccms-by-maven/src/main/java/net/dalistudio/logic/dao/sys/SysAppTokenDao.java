package net.dalistudio.logic.dao.sys;

// Generated 2016-3-2 20:55:08 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysAppToken;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysAppTokenDao extends BaseDao<SysAppToken> {
    public PageHandler getPage(Integer appId, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysAppToken bean");
        if (notEmpty(appId)) {
            queryHandler.condition("bean.appId = :appId").setParameter("appId", appId);
        }
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    public int delete(Date createDate) {
        if (notEmpty(createDate)) {
            QueryHandler queryHandler = getDeleteQueryHandler("from SysAppToken bean");
            queryHandler.condition("bean.createDate <= :createDate").setParameter("createDate", createDate);
            return delete(queryHandler);
        }
        return 0;
    }

    @Override
    protected SysAppToken init(SysAppToken entity) {
        if (empty(entity.getCreateDate())) {
            entity.setCreateDate(getDate());
        }
        return entity;
    }

}