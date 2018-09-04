package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.RuleMonitorKey;

public interface RuleMonitorMapper {
    int deleteByPrimaryKey(RuleMonitorKey key);

    int insert(RuleMonitorKey record);

    int insertSelective(RuleMonitorKey record);
}