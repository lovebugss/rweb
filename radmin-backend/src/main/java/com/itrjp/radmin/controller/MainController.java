package com.itrjp.radmin.controller;

import com.itrjp.common.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ren on 2018/11/3.
 */
@Controller
public class MainController {
//    @PostMapping(value = "login")
//
//    public ResultBean login(HttpServletRequest request, HttpServletResponse response){
//        Login login = new Login();
////        Login login = new Login();
////        login.setTicket("2222");
////        login.setToken("11111");
////        return ResultBean.success(login);
//        System.out.println("HomeController.login()");
//        // 登录失败从request中获取shiro处理的异常信息。
//        // shiroLoginFailure:就是shiro异常类的全类名.
//        String exception = (String) request.getAttribute("shiroLoginFailure");
//        System.out.println("exception=" + exception);
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.getName().equals(exception)) {
//                System.out.println("UnknownAccountException -- > 账号不存在：");
//                msg = "UnknownAccountException -- > 账号不存在：";
//            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//                msg = "IncorrectCredentialsException -- > 密码不正确：";
//            } else if ("kaptchaValidateFailed".equals(exception)) {
//                System.out.println("kaptchaValidateFailed -- > 验证码错误");
//                msg = "kaptchaValidateFailed -- > 验证码错误";
//            } else {
//                msg = "else >> "+exception;
//                System.out.println("else -- >" + exception);
//            }
//        }
////        map.put("msg", msg);
//        // 此方法不处理登录成功,由shiro进行处理
////        return "/login";
//        return ResultBean.success(login);
//    }
    @GetMapping("to_login")
    @ResponseBody
    public Result login(){
        return Result.error("未登陆");
    }
}
