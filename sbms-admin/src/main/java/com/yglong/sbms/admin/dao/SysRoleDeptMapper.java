package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysRoleDept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

    SysRoleDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDept record);

    int updateByPrimaryKey(SysRoleDept record);
}