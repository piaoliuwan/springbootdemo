package com.springboot.mybatis.config;

import com.springboot.mybatis.Interceptor.InterceptorOne;
import com.springboot.mybatis.Interceptor.InterceptorTwo;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@Configuration表示这是一个配置器
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /**
         * 拦截器是按照注册顺序执行的
         *
         * 如果顺序执行的过程中某一个拦截器返回的false那么将不会继续往下执行  eg:如果two的prehandler返回的是false那么one将不会继续执行
         */
        registry.addInterceptor(new InterceptorTwo()).addPathPatterns("/mybatis/**");
        registry.addInterceptor(new InterceptorOne()).addPathPatterns("/mybatis/**");//拦截mybatis下的任意方法拦截所有也可以写成 /**/**

        super.addInterceptors(registry);
    }
}
