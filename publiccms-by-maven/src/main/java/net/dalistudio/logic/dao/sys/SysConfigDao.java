package net.dalistudio.logic.dao.sys;

// Generated 2016-7-16 11:54:15 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysConfig;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysConfigDao extends BaseDao<SysConfig> {
    public PageHandler getPage(Integer siteId, String code, String subcode, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysConfig bean");
        if (notEmpty(siteId)) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        }
        if (notEmpty(code)) {
            queryHandler.condition("bean.code = :code").setParameter("code", code);
        }
        if (notEmpty(subcode)) {
            queryHandler.condition("bean.subcode = :subcode").setParameter("subcode", subcode);
        }
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    public SysConfig getEntity(int siteId, String code, String subcode) {
        if (notEmpty(code) && notEmpty(subcode)) {
            QueryHandler queryHandler = getQueryHandler("from SysConfig bean");
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
            queryHandler.condition("bean.code = :code").setParameter("code", code);
            queryHandler.condition("bean.subcode = :subcode").setParameter("subcode", subcode);
            return getEntity(queryHandler);
        }
        return null;
    }

    @Override
    protected SysConfig init(SysConfig entity) {
        return entity;
    }

}