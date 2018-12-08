package com.itrjp.radmin.controller;

import com.itrjp.common.result.Result;
import com.itrjp.radmin.bean.Login;
import com.itrjp.radmin.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

//    @GetMapping("login")
//    public String toLogin(){
//        return "login";
//    }
    @PostMapping("/login")
    @ResponseBody
    public Result login(HttpServletRequest request, HttpServletResponse response,@RequestBody User user) {
        Login login = new Login();
        System.out.println("HomeController.login()");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg = null;
        try {
            subject.login(token);
//            login.setTicket(username);
            login.setToken(token.getUsername());
            Cookie cookie = new Cookie("1234","dfasdf");
//            cookie.setValue("1234");
            response.addCookie(cookie);
            return Result.success(login);
        } catch (LockedAccountException lae) {
            token.clear();
            msg = "用户已经被锁定不能登录，请与管理员联系！";

        } catch (AuthenticationException e) {
            token.clear();
            msg = "用户或密码不正确！";
        }


        // 此方法不处理登录成功,由shiro进行处理
        return Result.error(msg);
    }
    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }

}