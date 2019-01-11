package com.itrjp.radmin.service;

import com.github.pagehelper.PageInfo;
import com.itrjp.radmin.bean.Role;

import java.util.List;

public interface RoleService extends IService<Role> {

    List<Role> queryRoleListWithSelected(Integer uid);

    PageInfo<Role> selectByPage(Role role, int start, int length);

    /**
     * 删除角色 同时删除角色资源表中的数据
     * @param roleid
     */
    public void delRole(Integer roleid);
}
