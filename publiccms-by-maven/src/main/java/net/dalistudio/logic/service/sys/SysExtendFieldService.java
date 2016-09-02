package net.dalistudio.logic.service.sys;

// Generated 2016-3-2 13:39:54 by com.wangdali.common.source.SourceMaker

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysExtendField;
import net.dalistudio.logic.dao.sys.SysExtendFieldDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysExtendFieldService extends BaseService<SysExtendField> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer extendId, Integer pageIndex, Integer pageSize) {
        return dao.getPage(extendId, pageIndex, pageSize);
    }

    @SuppressWarnings("unchecked")
    public void update(Integer extendId, List<SysExtendField> entitys) {
        if (notEmpty(extendId)) {
            Set<Integer> idList = new HashSet<Integer>();
            if (notEmpty(entitys)) {
                for (SysExtendField entity : entitys) {
                    if (notEmpty(entity.getId())) {
                        update(entity.getId(), entity, new String[] { "id", "extendId" });
                    } else {
                        entity.setExtendId(extendId);
                        save(entity);
                    }
                    idList.add(entity.getId());
                }
            }
            for (SysExtendField extend : (List<SysExtendField>) getPage(extendId, null, null).getList()) {
                if (!idList.contains(extend.getId())) {
                    delete(extend.getId());
                }
            }
        }
    }

    @Autowired
    private SysExtendFieldDao dao;
}