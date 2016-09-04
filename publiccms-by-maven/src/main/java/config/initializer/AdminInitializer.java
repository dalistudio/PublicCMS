package config.initializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.IntrospectorCleanupListener;

import com.wangdali.common.base.Base;
import com.wangdali.common.servlet.ErrorToNotFoundDispatcherServlet;

import config.AdminConfig;
import config.ApplicationConfig;

/**
 * 
 * AdminInitializer Servlet3.0 工程入口类
 *
 */
public class AdminInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {
    public static final String BASEPATH = "/admin";

    /*
     * 启动
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(IntrospectorCleanupListener.class); // 添加监听
        ApplicationConfig.basePath = servletContext.getRealPath("/"); // 获得真实路径
        super.onStartup(servletContext); // 启动
    }

    /*
     * 创建调度Servlet
     */
    @Override
    protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        ApplicationConfig.webApplicationContext = servletAppContext;
        return new ErrorToNotFoundDispatcherServlet(servletAppContext);
    }

    /*
     * 获得Servlet配置类
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { AdminConfig.class };
    }

    /*
     * 获得Servlet的名字
     */
    @Override
    protected String getServletName() {
        return this.getClass().getSimpleName();
    }

    /*
     * 获得Servlet映射
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { BASEPATH + "/*" };
    }

    /*
     * 获得根配置类
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ApplicationConfig.class };
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
