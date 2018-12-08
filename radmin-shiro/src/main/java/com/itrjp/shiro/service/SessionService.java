package com.itrjp.shiro.service;

import com.itrjp.shiro.model.UserOnline;

import java.util.List;


public interface SessionService {
	List<UserOnline> list();
    boolean forceLogout(String sessionId);
}
