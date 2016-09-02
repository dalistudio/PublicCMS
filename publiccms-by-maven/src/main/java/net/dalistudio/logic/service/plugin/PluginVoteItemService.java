package net.dalistudio.logic.service.plugin;

// Generated 2016-3-3 17:43:34 by com.wangdali.common.source.SourceMaker


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.plugin.PluginVoteItem;
import net.dalistudio.logic.dao.plugin.PluginVoteItemDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class PluginVoteItemService extends BaseService<PluginVoteItem> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer voteId, 
                String orderField, String orderType, Integer pageIndex, Integer pageSize) {
        return dao.getPage(voteId, 
                orderField, orderType, pageIndex, pageSize);
    }
    
    @Autowired
    private PluginVoteItemDao dao;
}