package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.Instance;

public interface InstanceMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(Instance record);

    int insertSelective(Instance record);

    Instance selectByPrimaryKey(String instanceId);

    int updateByPrimaryKeySelective(Instance record);

    int updateByPrimaryKey(Instance record);
}