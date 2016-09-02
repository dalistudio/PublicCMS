package net.dalistudio.views.api;

//Generated 2015-5-10 17:54:56 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractAppV1Directive;
import net.dalistudio.entities.sys.SysApp;
import net.dalistudio.entities.sys.SysUser;
import net.dalistudio.logic.component.StatisticsComponent;
import net.dalistudio.views.pojo.CmsContentStatistics;
import com.wangdali.common.handler.RenderHandler;

@Component
public class ContentClickDirective extends AbstractAppV1Directive {
    @Autowired
    private StatisticsComponent statisticsComponent;

    @Override
    public void execute(RenderHandler handler, SysApp app, SysUser user) throws IOException, Exception {
        Long id = handler.getLong("id");
        CmsContentStatistics contentStatistics = statisticsComponent.clicks(id);
        if (notEmpty(contentStatistics) && notEmpty(contentStatistics.getEntity())) {
            handler.put("clicks", contentStatistics.getEntity().getClicks() + contentStatistics.getClicks()).render();
        } else {
            handler.put("error", REQUIRED_PARAMTER + "id").render();
        }

    }

    @Override
    public boolean needUserToken() {
        return false;
    }

    @Override
    public boolean needAppToken() {
        return false;
    }

}