package com.pcwang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalException {
    /**
     * java.lang.NullPointerException
     * @ModelAndView 封装异常信息以及返回视图
     * @Exception  会将产生的异常对象注入到方法中
     */
    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullExceptionHandler(Exception e){
        ModelAndView model = new ModelAndView();
        model.addObject("error",e.toString());
        model.setViewName("myerror");
        return model;
    }
}
