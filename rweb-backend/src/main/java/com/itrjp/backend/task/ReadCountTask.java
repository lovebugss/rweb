package com.itrjp.backend.task;

import com.itrjp.core.redis.RedisService;
import com.itrjp.backend.mapper.ArticleReadCountMapper;
import com.itrjp.backend.model.ArticleReadCount;
import com.itrjp.backend.redis.ArticleKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by MAC on 2018/10/22.
 */

@Component
public class ReadCountTask {
    @Resource
    private RedisService redisService;
    @Resource
    private ArticleReadCountMapper articleReadCountMapper;
    private static final Logger logger =  LoggerFactory.getLogger(ReadCountTask.class);

    @Scheduled(cron = "0 0 0 * * ?")
    public void readCount() {

            logger.info("---开始执行---");
            List<Map.Entry<String, String>> hsacn = this.redisService.hsacn(ArticleKey.readCount, null);
            this.redisService.delete(ArticleKey.readCount, null);

            List<ArticleReadCount> list = new LinkedList<>();
            hsacn.forEach(m -> {
                ArticleReadCount articleReadCount = new ArticleReadCount(m.getKey(), Integer.parseInt(m.getValue()));
                list.add(articleReadCount);
                logger.info(articleReadCount.toString());
            });
            if (list != null && !list.isEmpty())
                this.articleReadCountMapper.updateBath(list);
            logger.info("---执行完毕---");
    }
}
