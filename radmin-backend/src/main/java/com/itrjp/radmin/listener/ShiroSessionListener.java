package com.itrjp.radmin.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class ShiroSessionListener implements SessionListener{
    private final AtomicInteger sessionCount = new AtomicInteger(0);
    private final Logger log = LoggerFactory.getLogger(ShiroSessionListener.class);

    /**
     * 会话创建时触发
     * @param session
     */
    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
        log.info("会话创建：{}，人数：{}",session.getId(),sessionCount);
    }

    /**
     * 会话停止时触发
     * @param session
     */
    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
        log.info("会话停止：{}，人数：{}",session.getId(),sessionCount);
    }

    /**
     * 会话过期时触发
     * @param session
     */
    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
        log.info("会话过期：{}，人数：{}",session.getId(),sessionCount);
    }
}