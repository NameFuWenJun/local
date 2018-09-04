package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.InstanceLog;

public interface InstanceLogMapper {
    int deleteByPrimaryKey(String logId);

    int insert(InstanceLog record);

    int insertSelective(InstanceLog record);

    InstanceLog selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(InstanceLog record);

    int updateByPrimaryKey(InstanceLog record);
}