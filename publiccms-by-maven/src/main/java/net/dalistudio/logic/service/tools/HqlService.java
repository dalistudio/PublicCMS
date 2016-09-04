package net.dalistudio.logic.service.tools;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.logic.dao.tools.HqlDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class HqlService extends BaseService<Object> {
    
    public int update(String hql) {
        return dao.update(hql);
    }

    public int delete(String hql) {
        return dao.delete(hql);
    }

    @Transactional(readOnly = true)
    public PageHandler getPage(String hql, Map<String, Object> paramters, Integer pageIndex, Integer pageSize) {
        return dao.getPage(hql, paramters, pageIndex, pageSize);
    }

    public void clear() {
        dao.clear();
    }
    
    @Autowired
    private HqlDao dao;
}
