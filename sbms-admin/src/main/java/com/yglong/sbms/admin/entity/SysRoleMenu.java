package com.yglong.sbms.admin.entity;

import java.util.Date;

public class SysRoleMenu extends BaseModel {
    private Long roleId;

    private Long menuId;

    public SysRoleMenu() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}