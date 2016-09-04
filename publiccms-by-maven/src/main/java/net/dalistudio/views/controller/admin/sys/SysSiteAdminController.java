package net.dalistudio.views.controller.admin.sys;

// Generated 2016-1-27 21:06:08 by com.wangdali.common.source.SourceMaker

import static com.wangdali.common.tools.RequestUtils.getIpAddress;
import static com.wangdali.common.tools.VerificationUtils.encode;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dalistudio.common.base.AbstractController;
import net.dalistudio.entities.log.LogOperate;
import net.dalistudio.entities.sys.SysDomain;
import net.dalistudio.entities.sys.SysRole;
import net.dalistudio.entities.sys.SysRoleUser;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.entities.sys.SysUser;
import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.logic.service.sys.SysDomainService;
import net.dalistudio.logic.service.sys.SysRoleService;
import net.dalistudio.logic.service.sys.SysRoleUserService;
import net.dalistudio.logic.service.sys.SysSiteService;
import net.dalistudio.logic.service.sys.SysUserService;

@Controller
@RequestMapping("sysSite")
public class SysSiteAdminController extends AbstractController {
    @Autowired
    private SysSiteService service;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleUserService roleUserService;
    @Autowired
    private SysDomainService domainService;

    @RequestMapping("save")
    public String save(SysSite entity, String roleName, String userName, String password, HttpServletRequest request,
            HttpSession session, ModelMap model) {
        SysSite site = getSite(request);
        if (!entity.isUseStatic()) {
            entity.setSitePath(entity.getDynamicPath());
            entity.setUseSsi(false);
        }
        if (notEmpty(entity.getId())) {
            entity = service.update(entity.getId(), entity, new String[] { "id" });
            if (notEmpty(entity)) {
                logOperateService.save(
                        new LogOperate(site.getId(), getAdminFromSession(session).getId(), LogLoginService.CHANNEL_WEB_MANAGER,
                                "update.site", getIpAddress(request), getDate(), entity.getId() + ":" + entity.getName()));
            }
        } else {
            if (verifyNotEmpty("userName", userName, model) || verifyNotEmpty("password", password, model)) {
                return TEMPLATE_ERROR;
            }
            service.save(entity);
            SysRole role = new SysRole(entity.getId(), roleName, true, true);
            roleService.save(role);// 初始化角色
            SysUser user = new SysUser(entity.getId(), userName, encode(password), userName, null, role.getId().toString(), null,
                    false, true, false, null, null, 0, getDate());
            userService.save(user);// 初始化用户
            roleUserService.save(new SysRoleUser(role.getId(), user.getId()));// 初始化角色用户映射
            logOperateService
                    .save(new LogOperate(site.getId(), getAdminFromSession(session).getId(), LogLoginService.CHANNEL_WEB_MANAGER,
                            "save.site", getIpAddress(request), getDate(), entity.getId() + ":" + entity.getName()));
        }
        siteComponent.clear();
        return TEMPLATE_DONE;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("delete")
    public String delete(Integer id, HttpServletRequest request, HttpSession session) {
        SysSite entity = service.getEntity(id);
        if (notEmpty(entity)) {
            service.delete(id);
            SysSite site = getSite(request);
            Long userId = getAdminFromSession(session).getId();
            Date now = getDate();
            String ip = getIpAddress(request);
            for (SysDomain domain : (List<SysDomain>) domainService.getPage(entity.getId(), null, null).getList()) {
                domainService.delete(domain.getId());
                logOperateService.save(new LogOperate(site.getId(), userId, LogLoginService.CHANNEL_WEB_MANAGER, "delete.domain",
                        ip, now, entity.getId() + ":" + entity.getName()));
            }
            logOperateService.save(new LogOperate(site.getId(), userId, LogLoginService.CHANNEL_WEB_MANAGER, "delete.site", ip,
                    now, entity.getId() + ":" + entity.getName()));
        }
        return TEMPLATE_DONE;
    }
}