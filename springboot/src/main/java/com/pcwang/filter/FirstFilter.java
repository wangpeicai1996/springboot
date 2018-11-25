package com.pcwang.filter;


import javax.naming.Name;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 传统的filter配置
 * <filter>
 *     <filter-name>FirstFilter</filter-name>
 *     <filter-class>com.xxx.xxx.xxxFilter</filter-class>
 * </filter>
 * <filter-mapping>
 *     <filter-name>FirstFilter</filter-name>
 *     <url-pattern>/first</url-pattern>
 * </filter-mapping>
 */
@WebFilter(filterName = "firstFilter",urlPatterns = {"/first"})
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    }
    @Override
    public void destroy() {
    }
}
