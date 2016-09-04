package net.dalistudio.logic.service.sys;

// Generated 2016-7-16 11:54:15 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysConfig;
import net.dalistudio.logic.dao.sys.SysConfigDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysConfigService extends BaseService<SysConfig> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, String code, String subcode, Integer pageIndex, Integer pageSize) {
        return dao.getPage(siteId, code, subcode, pageIndex, pageSize);
    }

    @Transactional(readOnly = true)
    public SysConfig getEntity(int siteId, String code, String subcode) {
        return dao.getEntity(siteId, code, subcode);
    }

    @Autowired
    private SysConfigDao dao;
}