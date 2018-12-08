package com.itrjp.radmin.filter;

/**
 * Created by ren on 2018/11/7.
 */
import com.alibaba.fastjson.JSONObject;
import com.itrjp.common.result.Result;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * shiro未登录反回状态码
 * @author xuguoqin
 * @date 2018年5月10日
 * @version 1.0
 */
public class LoginAuthorizationFilter extends FormAuthenticationFilter {

    /**
     * 这个方法是未登录需要执行的方法
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            //设置响应头
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json");
            //设置返回的数据
//            YfpjResult result = YfpjResult.build(UserAuthStatusEnum.UNLOGIN.getCode(), UserAuthStatusEnum.UNLOGIN.getMsg());

            //写回给客户端
            PrintWriter out = httpResponse.getWriter();
            out.write(JSONObject.toJSONString(Result.error("未登陆")));
            //刷新和关闭输出流
            out.flush();
            out.close();
        } else {
            //设置响应头
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json");
            //设置返回的数据
//            YfpjResult result = YfpjResult.build(UserAuthStatusEnum.UNAUTH.getCode(), UserAuthStatusEnum.UNAUTH.getMsg());
            //写回给客户端
            PrintWriter out = httpResponse.getWriter();
//            out.write(JSONObject.toJSONString(result));
            out.write(JSONObject.toJSONString(Result.success("登陆成功")));
            //刷新和关闭输出流
            out.flush();
            out.close();
        }
        return false;
    }
}
