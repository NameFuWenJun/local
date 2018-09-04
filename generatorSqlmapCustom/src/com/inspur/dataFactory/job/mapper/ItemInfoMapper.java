package com.inspur.dataFactory.job.mapper;

import com.inspur.dataFactory.job.pojo.reverseProxyPojo.ItemInfo;

public interface ItemInfoMapper {
    int deleteByPrimaryKey(String itemId);

    int insert(ItemInfo record);

    int insertSelective(ItemInfo record);

    ItemInfo selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(ItemInfo record);

    int updateByPrimaryKeyWithBLOBs(ItemInfo record);

    int updateByPrimaryKey(ItemInfo record);
}