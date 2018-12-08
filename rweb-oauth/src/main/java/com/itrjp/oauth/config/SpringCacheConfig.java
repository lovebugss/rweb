package com.itrjp.oauth.config;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by MAC on 2018/11/12.
 */
//@Configuration
//@AutoConfigureBefore(ShiroConfig.class)
@Order(1)
public class SpringCacheConfig {
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
}
