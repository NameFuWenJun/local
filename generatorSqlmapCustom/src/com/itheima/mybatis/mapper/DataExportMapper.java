package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.DataExport;

public interface DataExportMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(DataExport record);

    int insertSelective(DataExport record);

    DataExport selectByPrimaryKey(String instanceId);

    int updateByPrimaryKeySelective(DataExport record);

    int updateByPrimaryKey(DataExport record);
}