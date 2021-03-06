package net.dalistudio.common.base;

import static net.dalistudio.common.constants.CommonConstants.getCookiesUser;
import static net.dalistudio.common.constants.CommonConstants.getSessionAdmin;
import static net.dalistudio.common.constants.CommonConstants.getSessionUser;
import static net.dalistudio.common.constants.CommonConstants.getSessionUserTime;
import static com.wangdali.common.tools.RequestUtils.cancleCookie;
import static com.wangdali.common.tools.RequestUtils.getUserAgent;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;

import net.dalistudio.entities.sys.SysDomain;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.entities.sys.SysUser;
import net.dalistudio.logic.component.SiteComponent;
import net.dalistudio.logic.service.log.LogOperateService;
import com.wangdali.common.base.BaseController;

import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.UserAgent;

public abstract class AbstractController extends BaseController {
    protected static final String TEMPLATE_INDEX = "index";
    protected static final String TEMPLATE_DONE = "common/ajaxDone";
    protected static final String TEMPLATE_ERROR = "common/ajaxError";
    protected static final String MESSAGE = "message";
    protected static final String SUCCESS = "success";

    public static final Pattern MOBILE_PATTERN = Pattern.compile("^(13|14|15|17|18|)\\d{9}$");
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    public static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z_]{1}[0-9A-Za-z_]{3,40}$");
    public static final Pattern NICKNAME_PATTERN = Pattern.compile("^[0-9A-Za-z_\u4E00-\uFA29\uE7C7-\uE7F3]{2,45}$");
    private static final String VALID_CHARS = "[^\\s\\(\\)<>@,;:\\\\\\\"\\.\\[\\]+]+";
    public static final Pattern EMAIL_PATTERN = Pattern
            .compile("(" + VALID_CHARS + "(\\." + VALID_CHARS + ")*@" + VALID_CHARS + "(\\." + VALID_CHARS + ")*)");

    @Autowired
    protected LogOperateService logOperateService;
    @Autowired
    protected SiteComponent siteComponent;

    /*
     * 获得域名
     */
    protected SysDomain getDomain(HttpServletRequest request) {
        return siteComponent.getDomain(request.getServerName(), request.getServerPort());
    }

    /*
     * 获得网站
     */
    protected SysSite getSite(HttpServletRequest request) {
        return siteComponent.getSite(request.getServerName(), request.getServerPort());
    }

    protected static MappingJacksonValue getMappingJacksonValue(Object object, String callback) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(object);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

    /**
     * @param request
     * @return
     * @throws IllegalStateException
     */
    protected static DeviceType getDeviceType(HttpServletRequest request) {
        return UserAgent.parseUserAgentString(getUserAgent(request)).getOperatingSystem().getDeviceType();
    }

    /**
     * @param session
     * @return
     */
    public static SysUser getUserFromSession(HttpSession session) {
        return (SysUser) session.getAttribute(getSessionUser());
    }

    /**
     * @param session
     * @return
     */
    public static Date getUserTimeFromSession(HttpSession session) {
        return (Date) session.getAttribute(getSessionUserTime());
    }

    /**
     * @param session
     * @param user
     */
    public static void setUserToSession(HttpSession session, SysUser user) {
        session.setAttribute(getSessionUser(), user);
        session.setAttribute(getSessionUserTime(), getDate());
    }

    /**
     * @param request
     * @param response
     */
    public static void clearUserToSession(String contextPath, HttpSession session, HttpServletResponse response) {
        cancleCookie(contextPath, response, getCookiesUser(), null);
        session.removeAttribute(getSessionUser());
    }

    /**
     * @param session
     */
    public static void clearUserTimeToSession(HttpSession session) {
        session.removeAttribute(getSessionUserTime());
    }

    /**
     * 获得管理的会话
     * 
     * @param session
     * @return
     */
    public static SysUser getAdminFromSession(HttpSession session) {
        return (SysUser) session.getAttribute(getSessionAdmin());
    }

    /**
     * 设置管理员的会话
     * 
     * @param session
     * @param user
     */
    public static void setAdminToSession(HttpSession session, SysUser user) {
        session.setAttribute(getSessionAdmin(), user);
    }

    /**
     * 验证无用户名
     * 
     * @param value
     * @return
     */
    public static boolean verifyNotUserName(String value) {
        Matcher m = USERNAME_PATTERN.matcher(value);
        if (!m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 验证无昵称
     * 
     * @param value
     * @return
     */
    public static boolean verifyNotNickName(String value) {
        Matcher m = NICKNAME_PATTERN.matcher(value);
        if (!m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 验证无手机
     * 
     * @param value
     * @return
     */
    protected static boolean verifyNotMobile(String value) {
        Matcher m = MOBILE_PATTERN.matcher(value);
        if (!m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 验证无邮箱
     * 
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean verifyNotEMail(String field, String value, Map<String, Object> model) {
        if (verifyNotEMail(value)) {
            model.put(ERROR, "verify.notEmail." + field);
            return true;
        }
        return false;
    }

    /**
     * 验证无用户名
     * 
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean verifyNotUserName(String field, String value, Map<String, Object> model) {
        if (verifyNotUserName(value)) {
            model.put(ERROR, "verify.notUserName." + field);
            return true;
        }
        return false;
    }

    /**
     * 验证无昵称
     * 
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean verifyNotNickName(String field, String value, Map<String, Object> model) {
        if (verifyNotNickName(value)) {
            model.put(ERROR, "verify.notNickName." + field);
            return true;
        }
        return false;
    }

    /**
     * 验证无手机
     * 
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean verifyNotMobile(String field, String value, Map<String, Object> model) {
        if (verifyNotMobile(value)) {
            model.put(ERROR, "verify.notMobile." + field);
            return true;
        }
        return false;
    }

    /**
     * 验证无邮箱
     * 
     * @param value
     * @return
     */
    public static boolean verifyNotEMail(String value) {
        Matcher m = EMAIL_PATTERN.matcher(value);
        if (!m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * @param value
     * @return
     */
    public static boolean verifyNotNumber(String value) {
        Matcher m = NUMBER_PATTERN.matcher(value);
        if (!m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 验证无邮箱和手机
     * 
     * @param field
     * @param value
     * @param model
     * @return
     */
    protected static boolean verifyNotEMailAndMobile(String field, String value, Map<String, Object> model) {
        if (verifyNotEMail(value) && verifyNotMobile(value)) {
            model.put(ERROR, "verify.notEmailAndMobile." + field);
            return true;
        }
        return false;
    }

    /**
     * 清理管理员的会话
     * 
     * @param session
     */
    public static void clearAdminToSession(HttpSession session) {
        session.removeAttribute(getSessionAdmin());
    }
}
