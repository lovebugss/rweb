package com.itrjp.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MAC on 2018/11/12.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){return "index";}
}
