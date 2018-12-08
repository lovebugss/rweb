package com.itrjp.rweb.service.impl;

import com.github.pagehelper.PageHelper;
import com.itrjp.common.mapper.BaseMapper;
import com.itrjp.common.result.PagedResult;
import com.itrjp.common.service.BaseServiceImpl;
import com.itrjp.common.util.BeanUtil;
import com.itrjp.rweb.mapper.ArticleContentMapper;
import com.itrjp.rweb.mapper.ArticleMapper;
import com.itrjp.rweb.mapper.ArticleReadCountMapper;
import com.itrjp.rweb.model.Article;
import com.itrjp.rweb.model.ArticleContent;
import com.itrjp.rweb.model.Foo;
import com.itrjp.rweb.service.ArticleService;
import com.itrjp.rweb.service.SolrjService;
import com.itrjp.rweb.vo.ArticleVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ren on 2018/9/1.
 */
@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleVo> implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleContentMapper articleContentMapper;
    @Resource
    private ArticleReadCountMapper readCountMapper;
    @Resource
    private PVServiceImpl pvService;
    @Resource
    private SolrjService solrjService;

    @Override
    public BaseMapper getMapper() {
        return this.articleMapper;
    }

    @Override
    public ArticleVo insert(ArticleVo pojo) throws Exception {
        ArticleVo article = new ArticleVo();
        String id = UUID.randomUUID().toString();
        article.setId(id);
        int i = pojo.getContent().length();
        String sbu = pojo.getContent().substring(0, i * 15 / 100 < 4 ? 4 : i * 15 / 100);
        article.setDescription(sbu);
        article.setOriginal("原创");
        article.setCreateBy("admin");
        article.setCreateTime(new Date());
        int insert = this.articleMapper.insert(pojo);
        ArticleContent articleContent = new ArticleContent();
        articleContent.setContent(pojo.getContent());
        articleContent.setId(pojo.getId());
        this.articleContentMapper.insert(articleContent);
        readCountMapper.insertOne(id, 0);
        this.solrjService.add(new Foo(id,article.getArticleTitle()));
        return pojo;
    }

    @Override
    public ArticleVo selectByPrimaryKey(Object key) throws Exception {
        Article a = this.articleMapper.selectByPrimaryKey(key);
        if (a != null) {
            boolean b = pvService.setArticlePv(key.toString());
            Integer readCount = this.pvService.selectArticlePv(key.toString());
            ArticleVo article = BeanUtil.copyProperties(a, ArticleVo.class);
            ArticleContent articleContent = this.articleContentMapper.selectByPrimaryKey(key);
            article.setReadCount(readCount);
            if (articleContent != null) {
                article.setContent(articleContent.getContent());
            }
            return article;
        }
        return null;
    }

    @Override
    public PagedResult<ArticleVo> findPageList(Integer pageNo, Integer pageSize, ArticleVo pojo) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
//        PageHelper.orderBy("CREATE_DATE desc");//默认都是以时间来排序
        //分页查询
        PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        List<Article> list = this.getMapper().selectAll();
        List<ArticleVo> articleVos = BeanUtil.copyProperties(list, ArticleVo.class);
        articleVos.forEach(articleVo -> {
            Integer rc = this.pvService.selectArticlePv(articleVo.getId());
            articleVo.setReadCount(rc);
        });
        return BeanUtil.toPagedResult(articleVos);
    }

    @Override
    public List<ArticleVo> findHotList() {

        List<Article> articles = this.articleMapper.selectHot();
        List<ArticleVo> articleVos = BeanUtil.copyProperties(articles, ArticleVo.class);
        return articleVos;
    }
}
