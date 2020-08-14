package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);
}