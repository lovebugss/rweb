package com.itrjp.radmin.controller;

import com.itrjp.radmin.bean.User;
import com.itrjp.radmin.dao.UserRepository;
import com.itrjp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * Created by ren on 2018/11/3.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    /**
     * 查询一条
     *
     * @return
     */
    @PostMapping("info")
    public Result getOne(Integer usercode) {
//        User user = new User();
//        user.setId(1);
//        user.setUsername("admin");
//        user.setPassword("111111");
//        user.setChineseName("管理员");
//        user.setIdcardNo("000000");
        Optional<User> user = userRepository.findById(usercode);
        return Result.success(user.get());
    }

    /**
     * 获取所有
     *
     * @return
     */
    @GetMapping("list")
    public Result getAll() {
        return null;
    }

    /**
     * 保存
     *
     * @return
     */
    @PostMapping("save")
    public Result save() {


        return Result.success(null);
    }

    /**
     * 更新
     *
     * @return
     */
    @PutMapping("update")
    public Result update() {
        return null;
    }

    /**
     * 更新状态
     *
     * @return
     */
    @PutMapping("updateStatus")
    public Result updateStatus() {
        return null;
    }

    /**
     * 删除一条
     *
     * @return
     */
    @DeleteMapping("{id}")
    public Result delete() {
        return null;
    }


}
