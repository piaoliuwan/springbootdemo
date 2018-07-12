package com.sprigboot.demo.Girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAspect {
    private final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.sprigboot.demo.Girl.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"_"+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
        logger.info("11111111111111");
    }

    @After("log()")
    public void after(){
        logger.info("22222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfter(Object object){
        logger.info("response={}",object.toString());
}
}
