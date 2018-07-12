package com.sprigboot.demo.Girl.service;

import com.sprigboot.demo.Girl.Exception.GirlException;
import com.sprigboot.demo.Girl.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class girlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void testTransaction(){
        Girl girl = new Girl();
        girl.setAge(11);
        girl.setCupSize("B");
        girlRepository.save(girl);

        Girl girl1 = new Girl();
        girl1.setAge(11);
        girl1.setCupSize("B");
        girlRepository.save(girl1);
        int x = 1/0;
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age<10){
            throw new GirlException(100,"应该还在上小学吧");
        }else if(age<16 && age>10){
            throw new GirlException(100,"应该还在上初中吧");
        }else{

        }
    }
}
