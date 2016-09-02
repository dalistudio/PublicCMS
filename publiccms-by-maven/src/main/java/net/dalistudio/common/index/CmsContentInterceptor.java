package net.dalistudio.common.index;

import org.hibernate.search.indexes.interceptor.EntityIndexingInterceptor;
import org.hibernate.search.indexes.interceptor.IndexingOverride;

import net.dalistudio.entities.cms.CmsContent;
import net.dalistudio.logic.service.cms.CmsContentService;

public class CmsContentInterceptor implements EntityIndexingInterceptor<CmsContent> {
    @Override
    public IndexingOverride onAdd(CmsContent entity) {
        if (CmsContentService.STATUS_NORMAL == entity.getStatus() && !entity.isDisabled()) {
            return IndexingOverride.APPLY_DEFAULT;
        }
        return IndexingOverride.SKIP;
    }
    
    @Override
    public IndexingOverride onDelete(CmsContent entity) {
        return IndexingOverride.APPLY_DEFAULT;
    }

    @Override
    public IndexingOverride onUpdate(CmsContent entity) {
        if (CmsContentService.STATUS_NORMAL == entity.getStatus() && !entity.isDisabled()) {
            return IndexingOverride.UPDATE;
        }
        return IndexingOverride.REMOVE;
    }

    @Override
    public IndexingOverride onCollectionUpdate(CmsContent entity) {
        return onUpdate(entity);
    }
}