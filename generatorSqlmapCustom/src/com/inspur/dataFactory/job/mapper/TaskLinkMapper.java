package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.TaskLink;
import com.inspur.dataFactory.job.pojo.reverseProxyPojo.TaskLinkKey;

public interface TaskLinkMapper {
    int deleteByPrimaryKey(TaskLinkKey key);

    int insert(TaskLink record);

    int insertSelective(TaskLink record);

    TaskLink selectByPrimaryKey(TaskLinkKey key);

    int updateByPrimaryKeySelective(TaskLink record);

    int updateByPrimaryKey(TaskLink record);
}