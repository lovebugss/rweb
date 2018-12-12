package com.itrjp.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 /*
  *
  * @Author renjp
  * @Date 2018/12/12 10:49
  * @Version 1.0
  **/
@RestController
public class ADController {

    @GetMapping("ad")
    public String ad(){
        return "ad";
    }
}
