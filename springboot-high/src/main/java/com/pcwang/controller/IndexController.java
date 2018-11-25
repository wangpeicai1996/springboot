package com.pcwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String show(){
        String str = null;
        str.length();//产生异常，会自动跳转error页面
        return "index";
    }


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
