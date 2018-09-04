package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.TableInfo;

public interface TableInfoMapper {
    int deleteByPrimaryKey(String tableId);

    int insert(TableInfo record);

    int insertSelective(TableInfo record);

    TableInfo selectByPrimaryKey(String tableId);

    int updateByPrimaryKeySelective(TableInfo record);

    int updateByPrimaryKey(TableInfo record);
}