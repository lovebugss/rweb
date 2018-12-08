package com.itrjp.common.remote;


import org.apache.shiro.session.Session;

import java.io.Serializable;


/*
 * 
 * @Author renjp
 * @Date 2018/11/20 15:19
 * @Version 1.0
 **/
public interface RemoteServiceInterface {

    /**
     * 获取session
     * @param appKey
     * @param sessionId
     * @return
     */
    Session getSession(String appKey, Serializable sessionId);

    /**
     * 创建session
     * @param session
     * @return
     */
    Serializable createSession(Session session);

    /**
     * 修改
     * @param appKey
     * @param session
     */
    void updateSession(String appKey, Session session);

    /**
     * 删除
     * @param appKey
     * @param session
     */
    void deleteSession(String appKey, Session session);

    PermissionContext getPermissions(String appKey, String username);
}
