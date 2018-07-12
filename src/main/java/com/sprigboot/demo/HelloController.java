package com.sprigboot.demo;

import com.sprigboot.demo.Girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

   /* @Value("${content}")
    private String content;*/
    @RequestMapping(value="/Hello/{id}", method = RequestMethod.GET)
    public String say(@PathVariable(value = "id",required = true) Integer  id){
      return id+ girlProperties.getCupSize();
      //  return "index";
    }

    @RequestMapping(value="/Hello", method = RequestMethod.GET)
    public String say2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer  id){
        return id+ girlProperties.getCupSize();
        //  return "index";
    }
}
