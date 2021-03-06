package net.dalistudio.views.controller.admin.sys;

import static com.wangdali.common.tools.RequestUtils.getIpAddress;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.dalistudio.common.base.AbstractController;
import net.dalistudio.entities.log.LogOperate;
import net.dalistudio.entities.sys.SysMoudle;
import net.dalistudio.entities.sys.SysRole;
import net.dalistudio.entities.sys.SysRoleMoudle;
import net.dalistudio.entities.sys.SysSite;
import net.dalistudio.logic.service.log.LogLoginService;
import net.dalistudio.logic.service.sys.SysMoudleService;
import net.dalistudio.logic.service.sys.SysRoleAuthorizedService;
import net.dalistudio.logic.service.sys.SysRoleMoudleService;
import net.dalistudio.logic.service.sys.SysRoleService;

@Controller
@RequestMapping("sysMoudle")
public class SysMoudleAdminController extends AbstractController {
    @Autowired
    private SysMoudleService service;
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysMoudleService moudleService;
    @Autowired
    private SysRoleMoudleService roleMoudleService;
    @Autowired
    private SysRoleAuthorizedService roleAuthorizedService;

    @RequestMapping("save")
    public String save(SysMoudle entity, HttpServletRequest request, HttpSession session) {
        SysSite site = getSite(request);
        if (notEmpty(entity.getId())) {
            entity = service.update(entity.getId(), entity, new String[] { "id" });
            if (notEmpty(entity)) {
                @SuppressWarnings("unchecked")
                List<SysRoleMoudle> roleMoudleList = (List<SysRoleMoudle>) roleMoudleService.getPage(null, entity.getId(), null,
                        null).getList();
                dealRoleAuthorized(roleMoudleList);
                logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(),
                        LogLoginService.CHANNEL_WEB_MANAGER, "update.moudle", getIpAddress(request), getDate(), entity.getId()
                                + ":" + entity.getName()));
            }
        } else {
            service.save(entity);
            logOperateService.save(new LogOperate(site.getId(), getAdminFromSession(session).getId(),
                    LogLoginService.CHANNEL_WEB_MANAGER, "save.moudle", getIpAddress(request), getDate(), entity.getId() + ":"
                            + entity.getName()));
        }
        return TEMPLATE_DONE;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("delete")
    public String delete(Integer id, HttpServletRequest request, HttpSession session) {
        SysMoudle entity = service.getEntity(id);
        if (notEmpty(entity)) {
            service.delete(id);
            List<SysRoleMoudle> roleMoudleList = (List<SysRoleMoudle>) roleMoudleService.getPage(null, id, null, null).getList();
            roleMoudleService.deleteByMoudleId(id);
            dealRoleAuthorized(roleMoudleList);
            logOperateService.save(new LogOperate(getSite(request).getId(), getAdminFromSession(session).getId(),
                    LogLoginService.CHANNEL_WEB_MANAGER, "delete.moudle", getIpAddress(request), getDate(), id + ":"
                            + entity.getName()));
        }
        return TEMPLATE_DONE;
    }

    @SuppressWarnings("unchecked")
    private void dealRoleAuthorized(List<SysRoleMoudle> roleMoudleList) {
        Set<String> pageUrls = moudleService.getPageUrl(null);
        for (SysRoleMoudle roleMoudle : roleMoudleList) {
            Set<Integer> moudleIds = new HashSet<Integer>();
            for (SysRoleMoudle roleMoudle2 : (List<SysRoleMoudle>) roleMoudleService.getPage(roleMoudle.getRoleId(), null, null,
                    null).getList()) {
                moudleIds.add(roleMoudle2.getMoudleId());
            }
            SysRole role = roleService.getEntity(roleMoudle.getRoleId());
            if (!moudleIds.isEmpty() && notEmpty(role) && !role.isOwnsAllRight()) {
                roleAuthorizedService.dealRoleMoudles(roleMoudle.getRoleId(), role.isShowAllMoudle(),
                        service.getEntitys(moudleIds.toArray(new Integer[moudleIds.size()])), pageUrls);
            }
        }
    }
}