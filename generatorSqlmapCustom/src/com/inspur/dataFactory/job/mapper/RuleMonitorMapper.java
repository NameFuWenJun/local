package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.RuleMonitorKey;

public interface RuleMonitorMapper {
    int deleteByPrimaryKey(RuleMonitorKey key);

    int insert(RuleMonitorKey record);

    int insertSelective(RuleMonitorKey record);
}