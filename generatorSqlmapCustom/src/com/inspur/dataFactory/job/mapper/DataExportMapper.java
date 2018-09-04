package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.DataExport;

public interface DataExportMapper {
    int deleteByPrimaryKey(String instanceId);

    int insert(DataExport record);

    int insertSelective(DataExport record);

    DataExport selectByPrimaryKey(String instanceId);

    int updateByPrimaryKeySelective(DataExport record);

    int updateByPrimaryKey(DataExport record);
}