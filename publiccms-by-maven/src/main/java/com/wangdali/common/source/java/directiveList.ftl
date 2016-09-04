package ${base}.${directivePack};

// Generated ${.now} by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

<#include "../include_imports/service.ftl">

import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;
import com.wangdali.common.handler.PageHandler;

@Component
public class ${entityName}ListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        PageHandler page = service.getPage(<#include "../include_condition/directive.ftl">);
        handler.put("page", page).render();
    }

    @Autowired
    private ${entityName}Service service;

}