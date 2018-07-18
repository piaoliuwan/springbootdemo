package com.springboot.mybatis.controller;

import com.springboot.mybatis.mapper.GirlMapper;
import com.springboot.mybatis.pojo.Girl;
import com.springboot.mybatis.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private GirlService  girlService;

    @GetMapping(value = "mybatis/test")
    public void add(){
        Girl girl = new Girl();
        girl.setAge(14);
        girl.setCupSize("B");
        girl.setMoney(500.0);
        girlService.save(girl);
    }
}
