package com.itrjp.radmin.service.impl;


import com.itrjp.radmin.bean.User;
import com.itrjp.radmin.dao.UserInfoDao;
import com.itrjp.radmin.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public User findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}