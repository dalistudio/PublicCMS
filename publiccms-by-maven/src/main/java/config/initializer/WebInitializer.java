package config.initializer;

import javax.servlet.Filter;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import net.dalistudio.common.servlet.MultiSiteDispatcherServlet;
import com.wangdali.common.base.Base;

import config.WebConfig;

/**
 * 
 * WebInitializer Servlet3.0 工程入口类
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	/*
	 * 获得根配置类
	 */
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

	/*
	 * 创建调度 Servlet
	 */
    @Override
    protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        return new MultiSiteDispatcherServlet(servletAppContext); // 多网站调度Servlet
    }

    /*
     * 获得Servlet的名字
     */
    @Override
    protected String getServletName() {
        return this.getClass().getSimpleName();
    }

    /*
     * 获得Servlet配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    /*
     * 获得Servlet映射
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /*
     * 获得Servlet过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter(); // 字符集编码过滤器
        characterEncodingFilter.setEncoding(Base.DEFAULT_CHARSET); // 默认字符集
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] { characterEncodingFilter };
    }
}
