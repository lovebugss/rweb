package com.itrjp.rweb.service;

import com.itrjp.common.service.BaseService;
import com.itrjp.rweb.vo.ArticleVo;

import java.util.List;

/**
 * Created by ren on 2018/9/1.
 */
public interface ArticleService extends BaseService<ArticleVo> {
    List<ArticleVo> findHotList();
}
