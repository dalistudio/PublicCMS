package net.dalistudio.views.directive.task;

import static org.apache.commons.lang3.time.DateUtils.addMonths;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractTaskDirective;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.logic.service.log.LogOperateService;
import net.dalistudio.logic.service.log.LogTaskService;
import net.dalistudio.logic.service.log.LogUploadService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class ClearLogDirective extends AbstractTaskDirective {
    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Date date = handler.getDate("clearDate");
        if (empty(date)) {
            date = addMonths(getDate(), -3);
        }
        SysSite site = getSite(handler);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("loginLog:", logLoginService.delete(site.getId(), date));
        map.put("operateLog:", logOperateService.delete(site.getId(), date));
        map.put("taskLog:", logTaskService.delete(site.getId(), date));
        map.put("uploadLog:", logUploadService.delete(site.getId(), date));
        handler.put("result", map).render();
    }

    @Autowired
    private LogLoginService logLoginService;
    @Autowired
    private LogOperateService logOperateService;
    @Autowired
    private LogTaskService logTaskService;
    @Autowired
    private LogUploadService logUploadService;
}
