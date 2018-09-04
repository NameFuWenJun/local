package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.InstanceLog;

public interface InstanceLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(InstanceLog record);

    int insertSelective(InstanceLog record);

    InstanceLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(InstanceLog record);

    int updateByPrimaryKey(InstanceLog record);
}