package com.pcwang.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理类，实现HandlerExceptionResolver接口
 */
@Configuration
public class CustomGlobalException implements HandlerExceptionResolver {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView model = new ModelAndView();
        //通过判断不同的异常类型，实现不同视图的跳转
        if(ex instanceof ArithmeticException){
            model.setViewName("error");
        }
        if(ex instanceof NullPointerException){
            model.setViewName("myerror");
        }
        model.addObject("error",ex.toString());//传递异常对象到模型域
        return model;
    }
}
