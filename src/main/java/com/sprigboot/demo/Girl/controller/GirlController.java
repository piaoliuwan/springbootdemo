package com.sprigboot.demo.Girl.controller;

import com.sprigboot.demo.Girl.entity.Result;
import com.sprigboot.demo.Girl.service.GirlRepository;
import com.sprigboot.demo.Girl.entity.Girl;
import com.sprigboot.demo.Girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private com.sprigboot.demo.Girl.service.girlService girlService;

    private final Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * 查询女生列表
     * @return
     */
    @GetMapping(value = "girls")
    public List<Girl> getAllGirls(){
        logger.info("get All Girls");
        return girlRepository.findAll();
    }
    /**
     * 添加
     */
    @PostMapping(value = "addGirl")
    public Result<Girl> add(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResultUtils.failure(1,bindingResult.getFieldError().getDefaultMessage());

        }
        return ResultUtils.success(girlRepository.save(girl));
    }

    /**
     * 查询
     */
    @GetMapping(value = "find/{id}")
    public Girl findById(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 查询
     *
     */
    @GetMapping(value = "findByAge/{age}")
    public  List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 更新
     */
    @PutMapping(value="update/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,@RequestParam("age") Integer age,@RequestParam("cupSize")String cupSize ){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "delete/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
         girlRepository.deleteById(id);
    }

    @PutMapping(value = "testTrans")
    public void testTrans(){
        girlService.testTransaction();
    }

    @GetMapping(value = "getGirlByAge/{id}")
    public void getGirlByAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id) ;
    }

    /**
     * 热部署
     */
    @GetMapping(value = "hot")
    public String hot(){
        return "热部署；热部踩踩踩v反對頂頂頂頂頂aaaa頂頂頂署jjjjjj1。。。";
    }
}
