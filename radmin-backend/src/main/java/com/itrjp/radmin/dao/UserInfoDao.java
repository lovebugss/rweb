package com.itrjp.radmin.dao;

import com.itrjp.radmin.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<User,Long> {
    /**通过username查找用户信息;*/
    public User findByUsername(String username);
}