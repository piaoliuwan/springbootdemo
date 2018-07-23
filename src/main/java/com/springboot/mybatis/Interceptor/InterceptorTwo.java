package com.springboot.mybatis.Interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterceptorTwo implements HandlerInterceptor{
    /**
     * 请求处理之前调用（controller方法之前调用）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("被Two拦截到,没有放行");
        return false;
    }

    /**
     * 请求处理之后进行调用，但是是在渲染视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                              @Nullable ModelAndView modelAndView) throws Exception {

    }

    /**
     * 整个请求结束之后被调用，也就是在DispatcherServlet渲染了对应的视图之后执行（主要是用来清理资源）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                 @Nullable Exception ex) throws Exception {
    }
}
