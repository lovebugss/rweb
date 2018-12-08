package com.itrjp.oauth.web.controller;

import com.itrjp.common.Constants;
import com.itrjp.oauth.bean.Resource;
import com.itrjp.oauth.bean.User;
import com.itrjp.oauth.service.AuthorizationService;
import com.itrjp.oauth.service.ResourceService;
import com.itrjp.oauth.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
//@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = authorizationService.findPermissions(Constants.SERVER_APP_KEY, loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


}
