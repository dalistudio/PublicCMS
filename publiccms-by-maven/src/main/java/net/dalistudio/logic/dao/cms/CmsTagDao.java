package net.dalistudio.logic.dao.cms;

// Generated 2015-7-10 16:36:23 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.cms.CmsTag;
import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class CmsTagDao extends BaseDao<CmsTag> {
    public PageHandler getPage(Integer siteId, Integer typeId, String name, String orderField, String orderType,
            Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsTag bean");
        if (notEmpty(siteId)) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", siteId);
        }
        if (notEmpty(typeId)) {
            queryHandler.condition("bean.typeId = :typeId").setParameter("typeId", typeId);
        }
        if (notEmpty(name)) {
            queryHandler.condition("bean.name like :name").setParameter("name", likeStart(name));
        }
        if ("asc".equalsIgnoreCase(orderType)) {
            orderType = "asc";
        } else {
            orderType = "desc";
        }
        if (null == orderField) {
            orderField = "";
        }
        switch (orderField) {
        case "searchCount":
            queryHandler.order("bean.searchCount " + orderType);
            break;
        default:
            queryHandler.order("bean.id " + orderType);
        }
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected CmsTag init(CmsTag entity) {
        return entity;
    }

}