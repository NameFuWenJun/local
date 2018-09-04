package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.ExtractRule;

public interface ExtractRuleMapper {
    int deleteByPrimaryKey(String ruleId);

    int insert(ExtractRule record);

    int insertSelective(ExtractRule record);

    ExtractRule selectByPrimaryKey(String ruleId);

    int updateByPrimaryKeySelective(ExtractRule record);

    int updateByPrimaryKey(ExtractRule record);
}