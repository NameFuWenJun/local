package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.LinkMonitor;

public interface LinkMonitorMapper {
    int deleteByPrimaryKey(String linkId);

    int insert(LinkMonitor record);

    int insertSelective(LinkMonitor record);
}