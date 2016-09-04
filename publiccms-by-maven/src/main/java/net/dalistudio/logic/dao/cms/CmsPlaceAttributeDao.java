package net.dalistudio.logic.dao.cms;

// Generated 2016-3-1 17:29:33 by com.wangdali.common.source.SourceMaker

import org.springframework.stereotype.Repository;

import net.dalistudio.entities.cms.CmsPlaceAttribute;
import com.wangdali.common.base.BaseDao;

@Repository
public class CmsPlaceAttributeDao extends BaseDao<CmsPlaceAttribute> {
    @Override
    protected CmsPlaceAttribute init(CmsPlaceAttribute entity) {
        return entity;
    }

}