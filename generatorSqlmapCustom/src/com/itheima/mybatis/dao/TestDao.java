package com.itheima.mybatis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itheima.mybatis.mapper.DataExportMapper;
import com.itheima.mybatis.pojo.DataExport;

@Repository
public class TestDao {
    @Autowired
    DataExportMapper dataExportMapper;
    
    public void insert(DataExport data){
        
    }
    
}
