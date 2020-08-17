package com.yglong.sbms.admin.service;

import com.yglong.sbms.admin.entity.SysMenu;
import com.yglong.sbms.core.service.CurdService;

import java.util.List;

public interface SysMenuService extends CurdService<SysMenu> {
    /**
     * 查询某用户的菜单列表
     * @param username
     * @return
     */
    List<SysMenu> findByUser(String username);
}
