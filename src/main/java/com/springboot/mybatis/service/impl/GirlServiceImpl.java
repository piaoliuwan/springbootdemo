package com.springboot.mybatis.service.impl;

import com.springboot.mybatis.mapper.GirlMapper;
import com.springboot.mybatis.pojo.Girl;
import com.springboot.mybatis.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlServiceImpl implements GirlService {
    @Autowired
    private GirlMapper girlMapper;

    public Integer save(Girl girl){

       return girlMapper.insert(girl);
    }
}
