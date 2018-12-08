package com.itrjp.oauth.dao;


import com.itrjp.oauth.bean.Authorization;

import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface AuthorizationDao {

    Authorization createAuthorization(Authorization authorization);

    Authorization updateAuthorization(Authorization authorization);

    void deleteAuthorization(Long authorizationId);

    Authorization findOne(Long authorizationId);

    List<Authorization> findAll();

    Authorization findByAppUser(Long appId, Long userId);
}
