package com.itrjp.shiro.mapper;


import com.itrjp.shiro.model.Role;
import com.itrjp.shiro.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);
}