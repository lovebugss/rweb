package com.itrjp.oauth.controller;

import org.springframework.ui.Model;


//@Controller
public class IndexController {

//    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }



}
