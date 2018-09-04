package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.ParseRule;

public interface ParseRuleMapper {
    int deleteByPrimaryKey(String ruleId);

    int insert(ParseRule record);

    int insertSelective(ParseRule record);

    ParseRule selectByPrimaryKey(String ruleId);

    int updateByPrimaryKeySelective(ParseRule record);

    int updateByPrimaryKey(ParseRule record);
}