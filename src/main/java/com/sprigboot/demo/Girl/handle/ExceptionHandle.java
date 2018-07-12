package com.sprigboot.demo.Girl.handle;

import com.sprigboot.demo.Girl.Exception.GirlException;
import com.sprigboot.demo.Girl.entity.Result;
import com.sprigboot.demo.Girl.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

       if(e instanceof GirlException){
           GirlException girlException = (GirlException)e;
          return ResultUtils.failure(girlException.getCode(),girlException.getMessage());
       }
        return ResultUtils.failure(-1,"未知错误");
    }
}
