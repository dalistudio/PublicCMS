package config.initializer;

import javax.servlet.Filter;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import net.dalistudio.common.servlet.MultiSiteDispatcherServlet;
import com.wangdali.common.base.Base;

import config.ApiConfig;

/**
 * 
 * WebInitializer Servlet3.0 工程入口类
 *
 */
public class ApiInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	/*
	 * 获得根配置类
	 */
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

	/*
	 * 创建调度Servlet
	 */
    @Override
    protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        return new MultiSiteDispatcherServlet(servletAppContext);
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
        return new Class[] { ApiConfig.class };
    }

    /*
     * 获得Servlet映射
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/api/*" };
    }

    /*
     * 获得Servlet过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(Base.DEFAULT_CHARSET);
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] { characterEncodingFilter };
    }
}
