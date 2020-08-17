package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysMenu;
import com.yglong.sbms.core.page.PageRequest;
import com.yglong.sbms.core.page.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findAll();

    List<SysMenu> findByUsername(@Param(value = "userName") String userName);

    PageResult findPage();
}