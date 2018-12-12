package com.itrjp.backend.service.impl;

import com.itrjp.common.util.HelpUtils;
import com.itrjp.core.redis.RedisService;
import com.itrjp.backend.mapper.ArticleReadCountMapper;
import com.itrjp.backend.redis.ArticleKey;
import com.itrjp.backend.service.PVService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by MAC on 2018/10/19.
 */
@Service
public class PVServiceImpl implements PVService {

    @Resource
    private RedisService redisService;
    @Resource
    private ArticleReadCountMapper articleReadCountMapper;
    @Override
    public Integer selectArticlePv(String id) {
        Integer pv = redisService.hget(ArticleKey.readCount,null,id, Integer.class);
        //Redis缓存中没有
        if (pv == null){
             pv = articleReadCountMapper.selectReadCountById(id);
            updateArticlePv(id,pv);
        }
        if (pv == null){
            pv = 0;
        }
        return pv;
    }

    @Override
    public boolean setArticlePv(String id) {
        boolean seccess = false;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //请求的IP
        String ip = HelpUtils.getRequestIp();
        
        Integer isReading = this.redisService.get(ArticleKey.reader, id + ip, Integer.class);
        if (isReading == null) {
            this.redisService.set(ArticleKey.reader,id+ip,1);
            Integer pv = selectArticlePv(id);
            seccess = updateArticlePv( id, pv + 1);

        }else{

        }
        return seccess;
    }


    @Override
    public boolean updateArticlePv(String id, Integer readCount) {

        return this.redisService.hset(ArticleKey.readCount,null, id, readCount);
    }

}
