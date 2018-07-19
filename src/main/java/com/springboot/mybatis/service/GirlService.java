package com.springboot.mybatis.service;

import com.springboot.mybatis.pojo.Girl;

import java.util.List;

public interface GirlService {
    Integer save(Girl girl);

    List<Girl> queryList();

    Girl myselfSelect(String id);
}
