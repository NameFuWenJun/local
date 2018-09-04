package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.ItemContraint;

public interface ItemContraintMapper {
    int deleteByPrimaryKey(String constraintId);

    int insert(ItemContraint record);

    int insertSelective(ItemContraint record);

    ItemContraint selectByPrimaryKey(String constraintId);

    int updateByPrimaryKeySelective(ItemContraint record);

    int updateByPrimaryKey(ItemContraint record);
}