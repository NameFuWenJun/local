package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.ExtractRule;

public interface ExtractRuleMapper {
    int deleteByPrimaryKey(String ruleId);

    int insert(ExtractRule record);

    int insertSelective(ExtractRule record);

    ExtractRule selectByPrimaryKey(String ruleId);

    int updateByPrimaryKeySelective(ExtractRule record);

    int updateByPrimaryKey(ExtractRule record);
}