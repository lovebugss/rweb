package com.itrjp.rweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ren on 2018/10/19.
 */
//@WebFilter(urlPatterns = "/*", filterName = "logFilter")
public class LogCastFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long strat = System.currentTimeMillis();
        request.getLocalAddr();
        chain.doFilter(request, response);
        System.out.println("耗时："+(System.currentTimeMillis() - strat));
    }

    @Override
    public void destroy() {

    }
}
