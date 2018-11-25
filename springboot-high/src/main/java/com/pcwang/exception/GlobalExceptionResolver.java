package com.pcwang.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * SimpleMappingExceptionResolver方式处理异常
 */
@Configuration
public class GlobalExceptionResolver {

    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        /**
         * 第一个参数表示异常的类型，给定异常类型的全限定名
         * 第二个参数表示异常产生是跳转视图的名称
         */
        mappings.put("java.lang.NullPointerException","myerror");
        mappings.put("java.lang.ArithmeticException","error");
        resolver.setExceptionMappings(mappings);//设置异常类型和跳转页面的映射关系
        return resolver;
    }

}
