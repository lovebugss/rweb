package com.itrjp.shiro.mapper;


import com.itrjp.shiro.model.UserRole;
import com.itrjp.shiro.util.MyMapper;

import java.util.List;

public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);
}