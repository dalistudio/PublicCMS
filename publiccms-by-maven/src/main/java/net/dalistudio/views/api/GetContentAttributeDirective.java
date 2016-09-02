package net.dalistudio.views.api;

import static net.dalistudio.common.tools.ExtendUtils.getExtendMap;

//Generated 2015-5-10 17:54:56 by com.wangdali.common.source.SourceMaker

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.common.base.AbstractAppV1Directive;
import net.dalistudio.entities.cms.CmsContentAttribute;
import net.dalistudio.entities.sys.SysApp;
import net.dalistudio.entities.sys.SysUser;
import net.dalistudio.logic.service.cms.CmsContentAttributeService;
import com.wangdali.common.handler.RenderHandler;

@Component
public class GetContentAttributeDirective extends AbstractAppV1Directive {

    @Override
    public void execute(RenderHandler handler, SysApp app, SysUser user) throws IOException, Exception {
        Long id = handler.getLong("id");
        CmsContentAttribute entity = service.getEntity(id);
        if (notEmpty(entity)) {
            Map<String, String> map = getExtendMap(entity.getData());
            map.put("text", entity.getText());
            map.put("source", entity.getSource());
            map.put("sourceUrl", entity.getSourceUrl());
            map.put("wordCount", String.valueOf(entity.getWordCount()));
            handler.put("attribute", map).render();
        }

    }

    @Autowired
    private CmsContentAttributeService service;

    @Override
    public boolean needUserToken() {
        return false;
    }

    @Override
    public boolean needAppToken() {
        return true;
    }

}