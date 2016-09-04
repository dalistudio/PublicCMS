package net.dalistudio.logic.service.sys;

// Generated 2015-7-22 13:48:39 by com.wangdali.common.source.SourceMaker

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.sys.SysMoudle;
import net.dalistudio.logic.dao.sys.SysMoudleDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class SysMoudleService extends BaseService<SysMoudle> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer parentId, Integer pageIndex, Integer pageSize) {
        return dao.getPage(parentId, pageIndex, pageSize);
    }

    @SuppressWarnings("unchecked")
    public Set<String> getPageUrl(Integer parentId) {
        Set<String> urls = new HashSet<String>();
        for (SysMoudle entity : (List<SysMoudle>) getPage(parentId, null, null).getList()) {
            if (notEmpty(entity.getUrl())) {
                int index = entity.getUrl().indexOf("?");
                urls.add(entity.getUrl().substring(0, index > 0 ? index : entity.getUrl().length()));
            }
            urls.addAll(getPageUrl(entity.getId()));
        }
        return urls;
    }
    
    @Autowired
    private SysMoudleDao dao;
}