package com.itrjp.radmin.controller;

import com.itrjp.common.result.Result;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ren on 2018/11/3.
 */
@RestController
@RequestMapping("role")
public class RoleController {

    /**
     * 查询一条
     *
     * @return
     */
    @GetMapping("{id}")
    public Result getOne() {
        return null;
    }

    /**
     * 获取所有
     *
     * @return
     */
    @GetMapping("list")
    public Result getAll() {
        return null;
    }

    /**
     * 保存
     *
     * @return
     */
    @PostMapping("save")
    public Result save() {


        return Result.success(null);
    }

    /**
     * 更新
     *
     * @return
     */
    @PutMapping("update")
    public Result update() {
        return null;
    }

    /**
     * 更新状态
     *
     * @return
     */
    @PutMapping("updateStatus")
    public Result updateStatus() {
        return null;
    }

    /**
     * 删除一条
     *
     * @return
     */
    @DeleteMapping("{id}")
    public Result delete() {
        return null;
    }
}
