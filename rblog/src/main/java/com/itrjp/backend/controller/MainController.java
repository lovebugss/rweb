package com.itrjp.backend.controller;

import com.itrjp.backend.systemlog.SystemLog;
import com.itrjp.backend.vo.ArticleVo;
import com.itrjp.common.result.PagedResult;
import com.itrjp.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by ren on 2018/9/1.
 */
@Controller
public class MainController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 主页
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping({"/","index"})
    public ModelAndView index(Integer pageNo, Integer pageSize) throws Exception {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("index");
        PagedResult<ArticleVo> pageList = restTemplate.getForObject("http://rweb-backend/article/list", PagedResult.class);
        mov.addObject("pageList", pageList);
//        List<? extends Article>  hotList = restTemplate.getForObject("http://rweb-backend/article/dc", List.class);
//        mov.addObject("hotList", hotList);
        mov.addObject("flag", "list");
        return mov;
    }

    @RequestMapping("list")
    @SystemLog(description = "查询文章列表")
    public ModelAndView getAll(Integer pageNo, Integer pageSize) throws Exception {
        ModelAndView mov = new ModelAndView();
        List<ArticleVo> articles = restTemplate.getForObject("http://rweb-backend/article/dc", List.class);
        PagedResult<ArticleVo> pageList = restTemplate.getForObject("http://rweb-backend/article/dc", PagedResult.class);
        mov.addObject("articles", articles);
        mov.addObject("pageList", pageList);
        mov.setViewName("common/list");
        return mov;
    }

    @RequestMapping("insert")
    @ResponseBody
    public Result<ArticleVo> insert(@RequestBody ArticleVo article) throws Exception {
        return Result.success(restTemplate.postForObject("http://rweb-backend/article/article", article, ArticleVo.class));
    }

    @RequestMapping("tags/{tags}")
    public ModelAndView tags(@PathVariable("tags") String tags) {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("");
        return mov;
    }

//    @RequestMapping("a/{id}")
//    public ModelAndView getArticle(@PathVariable("id") String id) throws Exception {
//        ModelAndView mov = new ModelAndView();
//        ArticleVo article = this.articleService.selectByPrimaryKey(id);
//        mov.addObject("article", article);
////        mov.addObject("pageList", pageList);
////        List<Article>  hotList = this.articleService.findHotList();
//        List<? extends Article> hotList = this.articleService.findHotList();
//        mov.addObject("hotList", hotList);
//        mov.setViewName("view");
//        return mov;
//    }
    @RequestMapping("edit")
    public ModelAndView edit(){
        ModelAndView mov = new ModelAndView();

        mov.setViewName("edit");
        return mov;
    }
}
