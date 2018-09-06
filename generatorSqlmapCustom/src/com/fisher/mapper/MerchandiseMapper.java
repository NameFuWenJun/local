package com.fisher.mapper;

import com.fisher.pojo.Merchandise;

public interface MerchandiseMapper {
    int deleteByPrimaryKey(Integer merchandiseId);

    int insert(Merchandise record);

    int insertSelective(Merchandise record);

    Merchandise selectByPrimaryKey(Integer merchandiseId);

    int updateByPrimaryKeySelective(Merchandise record);

    int updateByPrimaryKey(Merchandise record);
}