package com.itrjp.rweb.controller.api;

import com.itrjp.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MAC on 2018/10/24.
 */
@RestController
@RequestMapping("tag")
public class TagsController {

    @GetMapping("list")
    public Result<List<String>> getAll(){
        List<String> strings = Arrays.asList("Java", "Spring", "Html");
        return Result.success(strings);
    }
}
