package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.Website;

public interface WebsiteMapper {
    int deleteByPrimaryKey(String websiteId);

    int insert(Website record);

    int insertSelective(Website record);

    Website selectByPrimaryKey(String websiteId);

    int updateByPrimaryKeySelective(Website record);

    int updateByPrimaryKey(Website record);
}