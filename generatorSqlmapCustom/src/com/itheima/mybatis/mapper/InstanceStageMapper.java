package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.InstanceStage;
import com.itheima.mybatis.pojo.InstanceStageKey;

public interface InstanceStageMapper {
    int deleteByPrimaryKey(InstanceStageKey key);

    int insert(InstanceStage record);

    int insertSelective(InstanceStage record);

    InstanceStage selectByPrimaryKey(InstanceStageKey key);

    int updateByPrimaryKeySelective(InstanceStage record);

    int updateByPrimaryKey(InstanceStage record);
}