package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.ItemContraint;

public interface ItemContraintMapper {
    int deleteByPrimaryKey(String constraintId);

    int insert(ItemContraint record);

    int insertSelective(ItemContraint record);

    ItemContraint selectByPrimaryKey(String constraintId);

    int updateByPrimaryKeySelective(ItemContraint record);

    int updateByPrimaryKey(ItemContraint record);
}