package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.TableItemKey;

public interface TableItemMapper {
    int deleteByPrimaryKey(TableItemKey key);

    int insert(TableItemKey record);

    int insertSelective(TableItemKey record);
}