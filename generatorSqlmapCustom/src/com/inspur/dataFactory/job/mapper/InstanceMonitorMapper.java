package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.InstanceMonitor;

public interface InstanceMonitorMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(InstanceMonitor record);

    int insertSelective(InstanceMonitor record);
}