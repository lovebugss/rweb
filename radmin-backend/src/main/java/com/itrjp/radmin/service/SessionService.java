package com.itrjp.radmin.service;

import com.itrjp.radmin.bean.UserOnline;

import java.util.List;


public interface SessionService {
	List<UserOnline> list();
    boolean forceLogout(String sessionId);
}
