package com.yglong.sbms.admin.controller;

import com.yglong.sbms.admin.constants.SysConstants;
import com.yglong.sbms.admin.entity.SysUser;
import com.yglong.sbms.admin.service.SysUserService;
import com.yglong.sbms.admin.util.PasswordUtils;
import com.yglong.sbms.common.utils.FileUtils;
import com.yglong.sbms.core.http.HttpResult;
import com.yglong.sbms.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysUser user) {
        SysUser sysUser = sysUserService.findById(user.getId());

        // 判断是否是修改超级管理员
        if (null != sysUser && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
        }

        if (user.getPassword() != null) {
            String salt = PasswordUtils.getSalt();
            if (sysUser == null) {
                // 新增用户
                if (sysUserService.findByName(user.getName()) != null) {
                    return HttpResult.error("用户名已存在!");
                }
                String password = PasswordUtils.encode(user.getPassword(), salt);
                user.setPassword(password);
                user.setSalt(salt);
            } else {
                // 修改用户
                if (!user.getPassword().equals(sysUser.getPassword())) {
                    String password = PasswordUtils.encode(user.getPassword(), salt);
                    user.setPassword(password);
                    user.setSalt(salt);
                }
            }
        }

        return HttpResult.ok(sysUserService.save(user));
    }

    @PreAuthorize("hasAuthority('sys:user:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysUser> records) {
        for (SysUser record : records) {
            SysUser sysUser = sysUserService.findById(record.getId());
            if (null != sysUser && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许删除！");
            }
        }
        return HttpResult.ok(sysUserService.delete(records));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "/findByName")
    public HttpResult findByUserName(@RequestParam String username) {
        return HttpResult.ok(sysUserService.findByName(username));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "/findPermissions")
    public HttpResult findPermissions(@RequestParam String username) {
        return HttpResult.ok(sysUserService.findPermissions(username));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "/findUserRoles")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        return HttpResult.ok(sysUserService.findUserRoles(userId));
    }

    @PreAuthorize("hasAuthority('sys:user:view')")
    @PostMapping(value = "findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:user:export')")
    @PostMapping(value = "/exportExcelUser")
    public void exportUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }
}
