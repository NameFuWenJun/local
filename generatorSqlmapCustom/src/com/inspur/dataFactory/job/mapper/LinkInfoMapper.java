package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.LinkInfo;

public interface LinkInfoMapper {
    int deleteByPrimaryKey(String linkId);

    int insert(LinkInfo record);

    int insertSelective(LinkInfo record);

    LinkInfo selectByPrimaryKey(String linkId);

    int updateByPrimaryKeySelective(LinkInfo record);

    int updateByPrimaryKey(LinkInfo record);
}