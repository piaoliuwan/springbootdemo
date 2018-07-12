package com.sprigboot.demo.Girl.utils;

import com.sprigboot.demo.Girl.entity.Girl;
import com.sprigboot.demo.Girl.entity.Result;

public class ResultUtils {
    public static Result success(Girl data){
        Result result = new Result();
        result.setCode(0);
        result.setMeg("success");
        result.setData(data);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMeg("success");
        return result;
    }

    public static Result failure(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMeg(msg);
        return result;
    }
}
