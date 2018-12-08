package com.itrjp.radmin.controller;

import com.itrjp.common.result.Result;
import com.itrjp.radmin.service.MenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by ren on 2018/11/4.
 */
@RestController()
@RequestMapping("menu")
public class MenuController {

    @Resource
    private MenuService menuService;
    /**
     *
     * @return
     */
    @PostMapping("list")
    public Result getUserMenu(){
//        HashMap<String, List<Menu>> map = new HashMap<>();
//        map.put("list", menuService.getAll());
        return Result.success(menuService.getAll());
    }
}
