package ${base}.${daoPack};

// Generated ${.now} by com.wangdali.common.source.SourceMaker

<#include "../include_imports/field_type.ftl">

import org.springframework.stereotype.Repository;

<#include "../include_imports/entity.ftl">

import com.wangdali.common.base.BaseDao;
import com.wangdali.common.handler.PageHandler;
import com.wangdali.common.handler.QueryHandler;

@Repository
public class ${entityName}Dao extends BaseDao<${entityName}> {
    public PageHandler getPage(<#include "../include_condition/condition.ftl">) {
        QueryHandler queryHandler = getQueryHandler("from ${entityName} bean");
        <#include "../include_condition/hql.ftl">
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected ${entityName} init(${entityName} entity) {
        return entity;
    }

}