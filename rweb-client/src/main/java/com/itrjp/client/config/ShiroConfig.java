package com.itrjp.client.config;

import com.itrjp.client.shiro.OAuth2Realm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//import org.apache.shiro.session.mgt.quartz.QuartzSessionValidationScheduler;


/*
 * Shiro配置类
 * @Author renjp
 * @Date 2018/11/13 10:40
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {
    private final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
    @Value("${oauth2.loginUrl}")
    private String loginUrl;
    @Value("${oauth2.clientId}")
    private String clientId;
    @Value("${oauth2.clientSecret}")
    private String clientSecret;
    @Value("${oauth2.accessTokenUrl}")
    private String accessTokenUrl;
    @Value("${oauth2.userInfoUrl}")
    private String userInfoUrl;
    @Value("${oauth2.redirectUrl}")
    private String redirectUrl;

    /**
     * Shiro Web过滤器
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        if (logger.isDebugEnabled()) {
            logger.debug("init Shiro Configuration.shirFilter");
        }
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
//        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/oauth2Failure", "anon");
        filterChainDefinitionMap.put("/oauth2-login", "oauth2Authc");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/font-awesome/**", "anon");
        filterChainDefinitionMap.put("/**", "user");
//
//              / = anon
//                /oauth2Failure.jsp = anon
//                /oauth2-login = oauth2Authc
//                /logout = logout
//        /** = user
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        shiroFilter.setLoginUrl(loginUrl);
        Map<String, Filter> filterHashMap = new HashMap<>();
        filterHashMap.put("oauth2Authc", oAuth2AuthenticationFilter());
        shiroFilter.setFilters(filterHashMap);

        return shiroFilter;
    }

    @Bean
    public SecurityManager securityManager() {
        if (logger.isDebugEnabled()) {
            logger.debug("init ShiroConfiguration.securityManager");
        }
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(oAuth2Realm());
        securityManager.setCacheManager(cacheManager());
        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public Realm oAuth2Realm() {
        OAuth2Realm oAuth2Realm = new OAuth2Realm();
        oAuth2Realm.setCachingEnabled(true);
        oAuth2Realm.setAuthenticationCachingEnabled(true);
        oAuth2Realm.setAuthenticationCacheName("authenticationCache");
        oAuth2Realm.setAuthorizationCachingEnabled(true);
        oAuth2Realm.setAuthorizationCacheName("authorizationCache");

        oAuth2Realm.setClientId(clientId);
        oAuth2Realm.setClientSecret(clientSecret);
        oAuth2Realm.setAccessTokenUrl(accessTokenUrl);
        oAuth2Realm.setUserInfoUrl(userInfoUrl);
        oAuth2Realm.setRedirectUrl(redirectUrl);
        return oAuth2Realm;
    }

    @Bean
    public Filter oAuth2AuthenticationFilter() {
        OAuth2AuthenticationFilter filter = new OAuth2AuthenticationFilter();
        filter.setAuthcCodeParam("code");
        filter.setFailureUrl("/oauth2Failure");
        return filter;
    }

    @Bean
    public MethodInvokingFactoryBean MethodInvokingFactoryBean() {
        MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
        factoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        factoryBean.setArguments(securityManager());
        return factoryBean;
    }



//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        LifecycleBeanPostProcessor processor = new LifecycleBeanPostProcessor();
//        return processor;
//    }


    @Bean
    public CacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache.xml");
        return cacheManager;
    }


    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCipherKey(org.apache.shiro.codec.Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        rememberMeManager.setCookie(rememberMeCookie());
        return rememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setHttpOnly(true);
        simpleCookie.setMaxAge(60 * 60 * 24 * 30);
        return simpleCookie;
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(securityManager());
        return methodInvokingFactoryBean;
    }

    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1000 * 60 * 30);
        sessionManager.setDeleteInvalidSessions(true);
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setSessionValidationScheduler(sessionValidationScheduler());
        sessionManager.setSessionDAO(sessionDAO());
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(sessionIdCookie());
        return sessionManager;
    }
//
//    @Bean
//    public QuartzSessionValidationScheduler sessionValidationScheduler() {
//        QuartzSessionValidationScheduler sessionValidationScheduler = new QuartzSessionValidationScheduler();
//        sessionValidationScheduler.setSessionValidationInterval(1000 * 60 * 30);
//        sessionValidationScheduler.setSessionManager(sessionManager());
//        return sessionValidationScheduler;
//    }

    @Bean
    public SessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        sessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
        sessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());
        return sessionDAO;
    }

    @Bean
    public SimpleCookie sessionIdCookie() {
        SimpleCookie cookie = new SimpleCookie("sid");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        return cookie;
    }

}
