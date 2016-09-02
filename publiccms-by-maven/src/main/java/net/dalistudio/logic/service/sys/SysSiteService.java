package net.dalistudio.logic.service.sys;

// Generated 2015-7-3 16:18:22 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.dao.sys.SysSiteDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysSiteService extends BaseService<SysSite> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Boolean disabled, String name, Integer pageIndex, Integer pageSize) {
        return dao.getPage(disabled, name, pageIndex, pageSize);
    }

    public SysSite delete(Integer id) {
        SysSite entity = getEntity(id);
        if (notEmpty(entity)) {
            entity.setDisabled(true);
        }
        return entity;
    }
    
    @Autowired
    private SysSiteDao dao;
}