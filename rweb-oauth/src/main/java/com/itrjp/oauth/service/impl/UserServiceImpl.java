package com.itrjp.oauth.service.impl;

import com.itrjp.oauth.bean.User;
import com.itrjp.oauth.dao.UserDao;
import com.itrjp.oauth.service.PasswordHelper;
import com.itrjp.oauth.service.RoleService;
import com.itrjp.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/*
 * 
 * @Author renjp
 * @Date 2018/11/20 15:46
 * @Version 1.0
 **/
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private RoleService roleService;

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}
