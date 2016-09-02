package net.dalistudio.logic.service.sys;

import java.util.Date;

// Generated 2015-7-3 16:18:22 by com.wangdali.common.source.SourceMaker

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysTask;
import net.dalistudio.logic.dao.sys.SysTaskDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysTaskService extends BaseService<SysTask> {

	@Transactional(readOnly = true)
	public PageHandler getPage(Integer siteId, Integer status, Date beginUpdateDate, Integer pageIndex, Integer pageSize) {
		return dao.getPage(siteId, status, beginUpdateDate, pageIndex, pageSize);
	}

	public void updateStatus(Integer id, int status) {
		SysTask entity = dao.getEntity(id);
		if (notEmpty(entity)) {
			entity.setStatus(status);
		}
	}

	public boolean updateStatusToRunning(Integer id) {
		return 1 == dao.updateStatusToRunning(id);
	}

	@Autowired
	private SysTaskDao dao;
}