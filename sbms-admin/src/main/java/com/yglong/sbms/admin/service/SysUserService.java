package com.yglong.sbms.admin.service;

import com.yglong.sbms.admin.entity.SysUser;
import com.yglong.sbms.admin.entity.SysUserRole;
import com.yglong.sbms.core.page.PageRequest;
import com.yglong.sbms.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SysUserService extends CurdService<SysUser> {

    File createUserExcelFile(PageRequest pageRequest);

    SysUser findByName(String username);

    Set<String> findPermissions(String username);

    List<SysUserRole> findUserRoles(Long userId);
}
