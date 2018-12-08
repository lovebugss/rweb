package com.itrjp.oauth.dao;


import com.itrjp.oauth.bean.App;

import java.util.List;


public interface AppDao {

    App createApp(App app);

    App updateApp(App app);

    void deleteApp(Long appId);

    App findOne(Long appId);

    List<App> findAll();

    Long findAppIdByAppKey(String appKey);
}
