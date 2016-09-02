package net.dalistudio.views.directive.tools;

// Generated 2015-5-10 17:54:56 by com.wangdali.common.source.SourceMaker

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dalistudio.logic.component.FileComponent;
import net.dalistudio.common.base.AbstractTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

@Component
public class TaskTemplateListDirective extends AbstractTemplateDirective {

	@Override
	public void execute(RenderHandler handler) throws IOException, Exception {
		String path = handler.getString("path", SEPARATOR);
		handler.put("list", fileComponent.getFileList(siteComponent.getTaskTemplateFilePath(getSite(handler), path)))
				.render();
	}

	@Override
	public boolean needAppToken() {
		return true;
	}

	@Autowired
	private FileComponent fileComponent;
}