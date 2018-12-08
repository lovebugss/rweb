package com.itrjp.oauth.dao;


import com.itrjp.oauth.bean.User;

import java.util.List;


/*
 *
 * @Author renjp
 * @Date 2018/11/15 14:06
 * @Version 1.0
 **/
public interface UserDao {

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findOne(Long userId);

    List<User> findAll();

    User findByUsername(String username);

}
