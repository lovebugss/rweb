package com.itrjp.backend.mapper;

import com.itrjp.common.mapper.BaseMapper;
import com.itrjp.backend.model.Article;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> selectHot();
}