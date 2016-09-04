package net.dalistudio.logic.dao.sys;

// Generated 2016-2-15 21:14:44 by com.wangdali.common.source.SourceMaker


import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysFtpUser;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysFtpUserDao extends BaseDao<SysFtpUser> {
    public PageHandler getPage(Integer siteId, Integer name, 
                Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysFtpUser bean");
        if (notEmpty(siteId)) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        }
        if (notEmpty(name)) {
            queryHandler.condition("bean.name = :name").setParameter("name", name);
        }
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected SysFtpUser init(SysFtpUser entity) {
        return entity;
    }

}