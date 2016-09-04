package net.dalistudio.logic.service.sys;

// Generated 2016-3-2 20:55:08 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysAppToken;
import net.dalistudio.logic.dao.sys.SysAppTokenDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysAppTokenService extends BaseService<SysAppToken> {
    
    @Transactional(readOnly = true)
    public PageHandler getPage(Integer appId, Integer pageIndex, Integer pageSize) {
        return dao.getPage(appId, pageIndex, pageSize);
    }

    public int delete(Date createDate) {
        return dao.delete(createDate);
    }

    @Autowired
    private SysAppTokenDao dao;
}