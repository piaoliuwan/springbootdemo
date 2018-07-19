package com.springboot.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.springboot.mybatis.mapper.GirlMapper;
import com.springboot.mybatis.mapper.GirlMapperMySelf;
import com.springboot.mybatis.pojo.Girl;
import com.springboot.mybatis.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GirlServiceImpl implements GirlService {
    @Autowired
    private GirlMapper girlMapper;
    @Autowired
    private GirlMapperMySelf girlMapperMySelf;


    public Integer save(Girl girl){

       return girlMapper.insert(girl);
    }

    @Override
    public List<Girl> queryList() {
        PageHelper.startPage(1,3);
        Example example = new Example(Girl.class);
        Example.Criteria criteria = example.createCriteria();
        //criteria
        //criteria.andLike("nickname", "%" + user.getNickname() + "%");
        example.orderBy("id");
       List<Girl> list =  girlMapper.selectByExample(example);
       return list;
    }

    @Override
    public Girl myselfSelect(String id) {
        Girl girl = girlMapperMySelf.myselfSelect(id);
        return girl;
    }
}
