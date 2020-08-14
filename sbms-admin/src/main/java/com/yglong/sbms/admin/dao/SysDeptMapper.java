package com.yglong.sbms.admin.dao;

import com.yglong.sbms.admin.entity.SysDept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}