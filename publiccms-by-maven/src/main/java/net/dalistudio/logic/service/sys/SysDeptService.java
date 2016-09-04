package net.dalistudio.logic.service.sys;

// Generated 2015-7-20 11:46:39 by com.wangdali.common.source.SourceMaker

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysDept;
import net.dalistudio.logic.dao.sys.SysDeptDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysDeptService extends BaseService<SysDept> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, Integer parentId, Long userId, Integer pageIndex, Integer pageSize) {
        return dao.getPage(siteId, parentId, userId, pageIndex, pageSize);
    }

    public List<Integer> delete(int siteId, Integer id) {
        SysDept entity = getEntity(id);
        List<Integer> idList = new ArrayList<Integer>();
        if (notEmpty(entity) && siteId == entity.getSiteId()) {
            @SuppressWarnings("unchecked")
            List<SysDept> list = (List<SysDept>) getPage(entity.getSiteId(), entity.getId(), null, null, null).getList();
            for (SysDept child : list) {
                delete(child.getId());
                idList.add(child.getId());
            }
            dao.delete(id);
            idList.add(id);
        }
        return idList;
    }

    @Autowired
    private SysDeptDao dao;
}