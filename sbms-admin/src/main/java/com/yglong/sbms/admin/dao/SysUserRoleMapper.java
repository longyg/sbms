package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRole record);

    int updateByPrimaryKey(SysUserRole record);
}