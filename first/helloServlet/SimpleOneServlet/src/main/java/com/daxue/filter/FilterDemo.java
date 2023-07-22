package com.daxue.filter;

import com.daxue.servlet.ServletDemo2;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author daxue0929
 * @date 2023/7/23
 * 这里有个坑: 实现Filter,在java8上三个方法都要重写.
 * https://blog.csdn.net/q4930153/article/details/121042261
 */

@WebFilter(filterName = "FilterDemo", urlPatterns = "/demo2")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("enter demo2 filter...");


        //todo: 全局过滤器逻辑

        //过滤器判定通过,往下继续调用.
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
