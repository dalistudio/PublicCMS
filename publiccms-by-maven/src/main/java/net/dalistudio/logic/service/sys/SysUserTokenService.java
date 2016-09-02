package net.dalistudio.logic.service.sys;

// Generated 2016-1-20 11:19:18 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysUserToken;
import net.dalistudio.logic.dao.sys.SysUserTokenDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysUserTokenService extends BaseService<SysUserToken> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, Long userId, String channel, String orderType, Integer pageIndex,
            Integer pageSize) {
        return dao.getPage(siteId, userId, channel, orderType, pageIndex, pageSize);
    }

    public SysUserToken getEntity(String authToken) {
        return getEntity(authToken, "authToken");
    }

    @Autowired
    private SysUserTokenDao dao;
}