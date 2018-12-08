package com.itrjp.radmin.service;


import com.itrjp.radmin.bean.User;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public User findByUsername(String username);
}