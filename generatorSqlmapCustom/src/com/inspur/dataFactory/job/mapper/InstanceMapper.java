package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.Instance;

public interface InstanceMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(Instance record);

    int insertSelective(Instance record);

    Instance selectByPrimaryKey(String instanceId);

    int updateByPrimaryKeySelective(Instance record);

    int updateByPrimaryKey(Instance record);
}