package net.dalistudio.logic.service.plugin;

// Generated 2016-3-1 17:24:24 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.plugin.PluginLottery;
import net.dalistudio.logic.dao.plugin.PluginLotteryDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class PluginLotteryService extends BaseService<PluginLottery> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer siteId, Date startStartDate, Date endStartDate, Date startEndDate, Date endEndDate,
            Boolean disabled, String orderField, String orderType, Integer pageIndex, Integer pageSize) {
        return dao.getPage(siteId, startStartDate, endStartDate, startEndDate, endEndDate, disabled, orderField, orderType,
                pageIndex, pageSize);
    }

    @Autowired
    private PluginLotteryDao dao;
}