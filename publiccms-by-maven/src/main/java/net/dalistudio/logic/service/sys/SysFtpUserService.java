package net.dalistudio.logic.service.sys;

// Generated 2016-2-15 21:14:46 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysFtpUser;
import net.dalistudio.logic.dao.sys.SysFtpUserDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysFtpUserService extends BaseService<SysFtpUser> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, Integer name, Integer pageIndex, Integer pageSize) {
        return dao.getPage(siteId, name, pageIndex, pageSize);
    }

    public SysFtpUser findByName(String name) {
        return dao.getEntity(name, "name");
    }

    @Autowired
    private SysFtpUserDao dao;
}