package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.InstanceStage;
import com.inspur.dataFactory.job.pojo.reverseProxyPojo.InstanceStageKey;

public interface InstanceStageMapper {
    int deleteByPrimaryKey(InstanceStageKey key);

    int insert(InstanceStage record);

    int insertSelective(InstanceStage record);

    InstanceStage selectByPrimaryKey(InstanceStageKey key);

    int updateByPrimaryKeySelective(InstanceStage record);

    int updateByPrimaryKey(InstanceStage record);
}