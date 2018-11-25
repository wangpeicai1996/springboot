package com.pcwang;

import com.pcwang.filter.SecondFilter;
import com.pcwang.listener.SecondListener;
import com.pcwang.servlet.SecondServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.servlet.annotation.MultipartConfig;

@SpringBootApplication
@PropertySource(value = {"classpath:config/"})
@ServletComponentScan(basePackages = "com.pcwang.servlet")
@MapperScan("com.pcwang.mapper")
public class SpringbootApplication {

	@Bean
	public ServletRegistrationBean registrationServletBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}

	@Bean
	public FilterRegistrationBean registrationFilterBean(){
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
		//bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
		bean.addUrlPatterns("/second");
		return bean;
	}

	@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new SecondListener());
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
