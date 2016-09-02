package net.dalistudio.common.base;

import static net.dalistudio.logic.component.SiteComponent.CONTEXT_SITE;

import org.springframework.beans.factory.annotation.Autowired;

import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.component.SiteComponent;
import com.wangdali.common.directive.BaseTemplateDirective;
import com.wangdali.common.handler.RenderHandler;

/**
 * 
 * AbstractTemplateDirective 自定义模板指令基类
 *
 */
public abstract class AbstractTaskDirective extends BaseTemplateDirective {
    public SysSite getSite(RenderHandler handler) throws Exception {
        return (SysSite) handler.getAttribute(CONTEXT_SITE);
    }

    @Autowired
    protected SiteComponent siteComponent;
}