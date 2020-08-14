package com.yglong.sbms.admin.service;

import com.yglong.sbms.admin.entity.SysUser;
import com.yglong.sbms.core.page.PageRequest;
import com.yglong.sbms.core.service.CurdService;

import java.io.File;
import java.util.List;

public interface SysUserService extends CurdService<SysUser> {

    File createUserExcelFile(PageRequest pageRequest);
}
