package com.itrjp.radmin.controller;/**
 * Created by renjp on 2019/1/7.
 */

import com.itrjp.common.result.Result;
import com.itrjp.radmin.bean.Menu;
import com.itrjp.radmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author renjp
 * @Date 2019/1/7 15:44
 * @Version 1.0
 */
@RestController
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("list")
    public Result<List<Menu>> getMenus() {

        return Result.success(this.menuService.getAll());
    }
}
