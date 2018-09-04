package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.TableItemKey;

public interface TableItemMapper {
    int deleteByPrimaryKey(TableItemKey key);

    int insert(TableItemKey record);

    int insertSelective(TableItemKey record);
}