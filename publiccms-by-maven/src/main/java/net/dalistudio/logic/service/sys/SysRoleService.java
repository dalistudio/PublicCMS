package net.dalistudio.logic.service.sys;

// Generated 2015-7-20 11:46:39 by com.wangdali.common.source.SourceMaker

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysRole;
import net.dalistudio.logic.dao.sys.SysRoleDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysRoleService extends BaseService<SysRole> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, Integer pageIndex, Integer pageSize) {
        return dao.getPage(siteId, pageIndex, pageSize);
    }

    @Transactional(readOnly = true)
    public boolean showAllMoudle(Integer[] roleIds) {
        List<SysRole> list = getEntitys(roleIds);
        for (SysRole role : list) {
            if (role.isOwnsAllRight() || role.isShowAllMoudle()) {
                return true;
            }
        }
        return false;
    }

    @Transactional(readOnly = true)
    public boolean ownsAllRight(Integer[] roleIds) {
        List<SysRole> list = getEntitys(roleIds);
        for (SysRole role : list) {
            if (role.isOwnsAllRight()) {
                return true;
            }
        }
        return false;
    }

    @Autowired
    private SysRoleDao dao;
}