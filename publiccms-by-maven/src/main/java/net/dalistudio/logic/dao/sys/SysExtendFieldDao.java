package net.dalistudio.logic.dao.sys;

// Generated 2016-3-2 13:39:54 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.sys.SysExtendField;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class SysExtendFieldDao extends BaseDao<SysExtendField> {
    public PageHandler getPage(Integer extendId, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from SysExtendField bean");
        if (notEmpty(extendId)) {
            queryHandler.condition("bean.extendId = :extendId").setParameter("extendId", extendId);
        }
        queryHandler.order("bean.id desc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected SysExtendField init(SysExtendField entity) {
        return entity;
    }

}