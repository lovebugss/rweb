package com.itrjp.radmin.dao;


import com.itrjp.common.mapper.BaseMapper;
import com.itrjp.radmin.bean.UserRole;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    List<Integer> findUserIdByRoleId(Integer roleId);
}