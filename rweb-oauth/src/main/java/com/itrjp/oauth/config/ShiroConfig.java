package com.itrjp.oauth.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.itrjp.oauth.credentials.RetryLimitHashedCredentialsMatcher;
import com.itrjp.oauth.shiro.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/*
 * Shiro配置类
 * @Author renjp
 * @Date 2018/11/13 10:40
 * @Version 1.0
 **/
@Configuration
//@Import(SpringCacheConfig.class)
public class ShiroConfig {
    private final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

//    @Resource(name = "springCacheManager")
//    private EhCacheCacheManager springCacheManager;

    /**
     * Shiro Web过滤器
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        if (logger.isDebugEnabled()) {
            logger.debug("init ShiroConfiguration.shirFilter");
        }
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/login", "authc");
        filterChainDefinitionMap.put("/logout", "logout");

        filterChainDefinitionMap.put("/authorize", "anon");
        filterChainDefinitionMap.put("/accessToken", "anon");
        filterChainDefinitionMap.put("/userInfo", "anon");

        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/font-awesome/**", "anon");
        filterChainDefinitionMap.put("/**", "user");


        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        shiroFilter.setLoginUrl("/login");
        Map<String, Filter> filterHashMap = new HashMap<>();
        filterHashMap.put("authc", formAuthenticationFilter());
        shiroFilter.setFilters(filterHashMap);

        return shiroFilter;
    }
//    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/usersPage");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/font-awesome/**","anon");
        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //自定义加载权限资源关系
//        List<Resources> resourcesList = resourcesService.queryAll();
//        for(Resources resources:resourcesList){
//
//            if (StringUtil.isNotEmpty(resources.getResurl())) {
//                String permission = "perms[" + resources.getResurl()+ "]";
//                filterChainDefinitionMap.put(resources.getResurl(),permission);
//            }
//        }
        filterChainDefinitionMap.put("/**", "user");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    @Bean
    public FormAuthenticationFilter formAuthenticationFilter() {
        FormAuthenticationFilter filter = new FormAuthenticationFilter();
        filter.setUsernameParam("username");
        filter.setPasswordParam("password");
        filter.setRememberMeParam("rememberMe");
        filter.setLoginUrl("/login");
        return filter;
    }



    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        LifecycleBeanPostProcessor processor = new LifecycleBeanPostProcessor();
        return processor;
    }
    @Bean
    public SecurityManager securityManager() {
        if (logger.isDebugEnabled()) {
            logger.debug("init ShiroConfiguration.securityManager");
        }
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setCacheManager(cacheManager());
        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public UserRealm myShiroRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher());
        userRealm.setCachingEnabled(false);
        return userRealm;
    }

    @Bean
    public RetryLimitHashedCredentialsMatcher credentialsMatcher() {
        RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager());
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));

        return hashedCredentialsMatcher;
    }

    @Bean
    public CacheManager cacheManager() {
        SpringCacheManagerWrapper managerWrapper = new SpringCacheManagerWrapper();
        managerWrapper.setCacheManager(springCacheManager());
        return managerWrapper;
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
        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setSessionValidationScheduler(sessionValidationScheduler());
        sessionManager.setSessionDAO(sessionDAO());
        sessionManager.setSessionIdCookie(sessionIdCookie());
        sessionManager.setSessionIdCookieEnabled(true);
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
    @Bean
    public EhCacheManagerFactoryBean ehcacheManager() {

        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();

        Resource resource = new ClassPathResource("ehcache/ehcache.xml");
        cacheManagerFactoryBean.setConfigLocation(resource);
        return cacheManagerFactoryBean;
    }

    @Bean
    public EhCacheCacheManager springCacheManager() {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(ehcacheManager().getObject());
        return ehCacheCacheManager;
    }
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
