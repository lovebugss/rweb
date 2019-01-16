package com.itrjp.radmin.controller;/**
 * Created by renjp on 2019/1/11.
 */

import com.itrjp.common.result.Result;
import com.itrjp.radmin.bean.Login;
import com.itrjp.radmin.bean.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renjp
 * @Date 2019/1/11 15:06
 * @Version 1.0
 */
@RestController
public class HomeController {

    @GetMapping(value = "/error")
    public Result<String> error() {

        return Result.error("error");
    }
    /**
     * 登录方法
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public Result<Login> login(@RequestBody UserInfo user) {
        Result result = null;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            Login login = new Login();
            login.setToken(subject.getSession().getId().toString());
            login.setUsername(user.getUsername());
            result = Result.success(login);
        } catch (IncorrectCredentialsException e) {
            result = Result.error("密码错误");
        } catch (LockedAccountException e) {
            result = Result.error("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            result = Result.error("该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

}
