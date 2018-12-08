package com.itrjp.rweb.mapper;

import com.itrjp.common.mapper.BaseMapper;
import com.itrjp.rweb.model.Article;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> selectHot();
}