package com.itrjp.shiro.controller;

import com.itrjp.common.result.Result;
import com.itrjp.shiro.model.Login;
import com.itrjp.shiro.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by yangqj on 2017/4/21.
 */
@Controller
public class HomeController {
//    @RequestMapping(value="/login",method= RequestMethod.GET)
//    public String login(){
//        return "login";
//    }

//    @RequestMapping(value="/login")

    public String login(HttpServletRequest request, User user, Model model){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            return "redirect:usersPage";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }

//    @RequestMapping(value="login")
//    @ResponseBody
    public Result login(HttpServletResponse response, @RequestBody User user){
        Result result = null;
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
//            request.setAttribute("msg", "用户名或密码不能为空！");
            result =  Result.error("用户名或密码不能为空！");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            Login login = new Login();
            login.setToken(token.getPassword().toString());
            login.setTicket(token.getUsername());
            result =   Result.success(login);
            Cookie cookie = new Cookie("1234","dfasdf");
//            cookie.setValue("1234");
            response.addCookie(cookie);
        }catch (LockedAccountException lae) {
            token.clear();
//            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            result =  Result.error("用户已经被锁定不能登录，请与管理员联系！");
        } catch (AuthenticationException e) {
            token.clear();
//            request.setAttribute("msg", "用户或密码不正确！");
            result =  Result.error("用户或密码不正确");
        }
        return result;
    }
    @RequestMapping(value={"/usersPage",""})
    public String usersPage(){
        return "user/users";
    }

    @RequestMapping("/rolesPage")
    public String rolesPage(){
        return "role/roles";
    }

    @RequestMapping("/resourcesPage")
    public String resourcesPage(){
        return "resources/resources";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }
}
