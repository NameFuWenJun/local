package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.DataHandle;

public interface DataHandleMapper {
    int insert(DataHandle record);

    int insertSelective(DataHandle record);
}