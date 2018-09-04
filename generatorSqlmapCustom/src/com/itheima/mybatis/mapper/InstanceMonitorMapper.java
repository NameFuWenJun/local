package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.InstanceMonitor;

public interface InstanceMonitorMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(InstanceMonitor record);

    int insertSelective(InstanceMonitor record);
}