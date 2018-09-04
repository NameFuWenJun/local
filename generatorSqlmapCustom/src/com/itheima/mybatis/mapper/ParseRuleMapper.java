package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.ParseRule;

public interface ParseRuleMapper {
    int deleteByPrimaryKey(String ruleId);

    int insert(ParseRule record);

    int insertSelective(ParseRule record);

    ParseRule selectByPrimaryKey(String ruleId);

    int updateByPrimaryKeySelective(ParseRule record);

    int updateByPrimaryKey(ParseRule record);
}