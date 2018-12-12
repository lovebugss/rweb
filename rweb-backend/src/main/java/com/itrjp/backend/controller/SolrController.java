package com.itrjp.backend.controller;

import com.itrjp.common.result.Result;
import com.itrjp.backend.model.Foo;
import com.itrjp.backend.service.SolrjService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MAC on 2018/10/24.
 */
@Controller
public class SolrController {

    @Resource
    private SolrjService solrjService;
    @GetMapping("search")
    @ResponseBody
    public Result<List<Foo>> search(String k, String show, Integer p, Integer r) throws Exception {

        return Result.success(this.solrjService.search(show + ":" +k,p,r));
    }
}
