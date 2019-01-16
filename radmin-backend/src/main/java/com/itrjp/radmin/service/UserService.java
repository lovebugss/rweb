package com.itrjp.radmin.service;

import com.github.pagehelper.PageInfo;
import com.itrjp.radmin.bean.User;

import java.util.List;


public interface UserService extends IService<User> {
    PageInfo<User> selectByPage(User user, int start, int length);

    User selectByUsername(String username);

    void delUser(Integer userid);

    List<User> selectAll();
}
