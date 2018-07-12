package com.sprigboot.demo.Girl.Exception;

public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(Integer code,String msg){
        super(msg);
        this.code =code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
