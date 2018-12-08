package com.itrjp.oauth.service;


import com.itrjp.oauth.bean.Authorization;

import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface AuthorizationService {


    Authorization createAuthorization(Authorization authorization);

    Authorization updateAuthorization(Authorization authorization);

    void deleteAuthorization(Long authorizationId);

    Authorization findOne(Long authorizationId);

    List<Authorization> findAll();

    /**
     * 根据AppKey和用户名查找其角色
     *
     * @param username
     * @return
     */
    Set<String> findRoles(String appKey, String username);

    /**
     * 根据AppKey和用户名查找权限字符串
     *
     * @param username
     * @return
     */
    Set<String> findPermissions(String appKey, String username);


}
