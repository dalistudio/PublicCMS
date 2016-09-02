package net.dalistudio.logic.service.sys;

import java.io.Serializable;

// Generated 2016-7-16 11:56:50 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysCluster;
import net.dalistudio.logic.dao.sys.SysClusterDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysClusterService extends BaseService<SysCluster> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Date startHeartbeatDate, Date endHeartbeatDate, Boolean master, String orderField,
            String orderType, Integer pageIndex, Integer pageSize) {
        return dao.getPage(startHeartbeatDate, endHeartbeatDate, master, orderField, orderType, pageIndex, pageSize);
    }

    public void updateHeartbeatDate(Serializable id, Date date) {
        SysCluster entity = getEntity(id);
        if (notEmpty(entity)) {
            entity.setHeartbeatDate(date);
        }
    }
    
    public void updateMaster(Serializable id, boolean master) {
        SysCluster entity = getEntity(id);
        if (notEmpty(entity)) {
            entity.setMaster(master);
        }
    }

    @Autowired
    private SysClusterDao dao;
}