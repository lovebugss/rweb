package com.itrjp.backend.controller;

import com.itrjp.common.constant.CodeMsg;
import com.itrjp.common.result.PagedResult;
import com.itrjp.common.result.Result;
import com.itrjp.backend.service.ArticleService;
import com.itrjp.backend.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author renjp
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("list")
//    @SystemLog(description = "查询文章列表")
    public PagedResult<ArticleVo> getAll(Integer pageNo, Integer pageSize) throws Exception {

       return this.articleService.findPageList(pageNo, pageSize, null);
    }

    @PostMapping("insert")
    public Result<ArticleVo> insert(@RequestBody ArticleVo article) throws Exception {

        return Result.success(this.articleService.insert(article));
    }

    @GetMapping("tags/{tags}")
    public ModelAndView tags(@PathVariable("tags") String tags) {
        ModelAndView mov = new ModelAndView();
        mov.setViewName("");
        return mov;
    }

    @GetMapping("{id}")
    public Result<ArticleVo> getArticle(@PathVariable("id") String id) throws Exception {
        ArticleVo articleVo = this.articleService.selectByPrimaryKey(id);
        return articleVo == null?Result.error(CodeMsg.NOT_FOUND):Result.success(articleVo);
    }
    @PutMapping(value = "edit")
    public ModelAndView edit(){
        ModelAndView mov = new ModelAndView();

        mov.setViewName("edit");
        return mov;
    }
}
