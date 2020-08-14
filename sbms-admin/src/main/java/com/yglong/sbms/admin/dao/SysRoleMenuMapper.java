package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}