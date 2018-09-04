package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.LinkMonitor;

public interface LinkMonitorMapper {
    int deleteByPrimaryKey(String linkId);

    int insert(LinkMonitor record);

    int insertSelective(LinkMonitor record);
}