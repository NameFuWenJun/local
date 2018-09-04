package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.TaskLink;
import com.itheima.mybatis.pojo.TaskLinkKey;

public interface TaskLinkMapper {
    int deleteByPrimaryKey(TaskLinkKey key);

    int insert(TaskLink record);

    int insertSelective(TaskLink record);

    TaskLink selectByPrimaryKey(TaskLinkKey key);

    int updateByPrimaryKeySelective(TaskLink record);

    int updateByPrimaryKey(TaskLink record);
}