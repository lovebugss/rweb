package com.itrjp.shiro.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by ren on 2018/11/3.
 */
@WebFilter
public class RequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = null;
        if (request instanceof HttpServletRequest) {
            req = (HttpServletRequest) request;
        }
        HttpServletResponse res = null;
        if (response instanceof HttpServletResponse) {
            res = (HttpServletResponse) response;
        }
        if (req != null && res != null) {
            //设置允许传递的参数
            res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
            //设置允许带上cookie
            res.setHeader("Access-Control-Allow-Credentials", "true");
            String origin = Optional.ofNullable(req.getHeader("Origin")).orElse(req.getHeader("Referer"));
            //设置允许的请求来源
            res.setHeader("Access-Control-Allow-Origin", origin);
            //设置允许的请求方法
            res.setHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
        }
//        if("OPTIONS".equals(req.getMethod()) ){
//            return;
//        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
