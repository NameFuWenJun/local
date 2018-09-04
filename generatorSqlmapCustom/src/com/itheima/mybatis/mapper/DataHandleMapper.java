package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.DataHandle;

public interface DataHandleMapper {
    int insert(DataHandle record);

    int insertSelective(DataHandle record);
}