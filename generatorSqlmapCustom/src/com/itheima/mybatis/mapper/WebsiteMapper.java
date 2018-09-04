package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.Website;

public interface WebsiteMapper {
    int deleteByPrimaryKey(String websiteId);

    int insert(Website record);

    int insertSelective(Website record);

    Website selectByPrimaryKey(String websiteId);

    int updateByPrimaryKeySelective(Website record);

    int updateByPrimaryKey(Website record);
}