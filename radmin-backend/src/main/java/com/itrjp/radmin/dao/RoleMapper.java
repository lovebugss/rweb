package com.itrjp.radmin.dao;


import com.itrjp.common.mapper.BaseMapper;
import com.itrjp.radmin.bean.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> queryRoleListWithSelected(Integer id);
}