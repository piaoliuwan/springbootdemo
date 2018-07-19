package com.springboot.mybatis.mapper;

import com.springboot.mybatis.pojo.Girl;
import tk.mybatis.mapper.common.Mapper;

public interface GirlMapperMySelf extends Mapper<Girl> {
    Girl myselfSelect(String id);
}