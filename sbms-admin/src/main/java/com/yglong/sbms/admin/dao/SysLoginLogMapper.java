package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysLoginLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLoginLog record);

    int insertSelective(SysLoginLog record);

    SysLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLoginLog record);

    int updateByPrimaryKey(SysLoginLog record);
}