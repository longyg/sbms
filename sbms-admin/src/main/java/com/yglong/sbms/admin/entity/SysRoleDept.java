package com.yglong.sbms.admin.entity;

import java.util.Date;

public class SysRoleDept extends BaseModel {
    private Long roleId;

    private Long deptId;

    public SysRoleDept() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}