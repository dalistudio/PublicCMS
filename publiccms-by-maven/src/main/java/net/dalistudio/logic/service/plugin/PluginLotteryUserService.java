package net.dalistudio.logic.service.plugin;

// Generated 2016-3-1 17:24:24 by com.wangdali.common.source.SourceMaker

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.dalistudio.entities.plugin.PluginLotteryUser;
import net.dalistudio.logic.dao.plugin.PluginLotteryUserDao;
import com.wangdali.common.base.BaseService;
import com.wangdali.common.handler.PageHandler;

@Service
@Transactional
public class PluginLotteryUserService extends BaseService<PluginLotteryUser> {

    @Transactional(readOnly = true)
    public PageHandler getPage(Integer lotteryId, Long userId, Boolean winning, Date startCreateDate, Date endCreateDate,
            String orderType, Integer pageIndex, Integer pageSize) {
        return dao.getPage(lotteryId, userId, winning, startCreateDate, endCreateDate, orderType, pageIndex, pageSize);
    }

    @Autowired
    private PluginLotteryUserDao dao;
}