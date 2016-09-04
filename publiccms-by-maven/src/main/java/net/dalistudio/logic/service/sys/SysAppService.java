package net.dalistudio.logic.service.sys;

// Generated 2016-3-2 10:25:12 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysApp;
import net.dalistudio.logic.dao.sys.SysAppDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysAppService extends BaseService<SysApp> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, String channel, Integer pageIndex, Integer pageSize) {
        return dao.getPage(siteId, channel, pageIndex, pageSize);
    }

    public SysApp getEntity(String appKey) {
        return getEntity(appKey, "appKey");
    }

    @Autowired
    private SysAppDao dao;
}