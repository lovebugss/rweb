package com.itrjp.radmin.controller;/**
 * Created by renjp on 2019/1/15.
 */

import com.github.pagehelper.PageInfo;
import com.itrjp.common.result.Result;
import com.itrjp.radmin.bean.User;
import com.itrjp.radmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author renjp
 * @Date 2019/1/15 9:35
 * @Version 1.0
 */
@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     *
     * @return
     */
    @GetMapping("users")
    public Result<List<User>> getList() {
        return Result.success(this.userService.selectAll());
    }
    @GetMapping("users/{start}/{len}")
    public Result<PageInfo<User>> getListPage(@PathVariable("start") int start,@PathVariable("len") int len){

        return Result.success(this.userService.selectByPage(new User(),start,len));
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("user/{id}")
    public Result<User> getUser() {


        return null;
    }


    @PutMapping("user")
    public Result<User> updateUser() {
        return null;
    }

    @DeleteMapping("user/{id}")
    public Result<User> deleteUser() {
        return null;
    }
}
