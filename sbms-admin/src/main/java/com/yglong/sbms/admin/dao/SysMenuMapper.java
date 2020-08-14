package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}