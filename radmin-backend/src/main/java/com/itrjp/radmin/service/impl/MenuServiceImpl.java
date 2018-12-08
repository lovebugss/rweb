package com.itrjp.radmin.service.impl;

import com.itrjp.radmin.bean.Menu;
import com.itrjp.radmin.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ren on 2018/11/4.
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public List<Menu> getAll() {

        List<Menu> list = new ArrayList<>();
        List<Menu> list1 = new ArrayList<>();
        List<Menu> list2 = new ArrayList<>();

        Menu menu11 = new Menu("10061", "概览", "desk$/index", "");
        Menu menu12 = new Menu("10062", "图标", "echarts", "");
        Menu menu13 = new Menu("10063", "编辑器", "editor", "");
        Menu menu14 = new Menu("10064", "聊天室", "chat", "");
        list1.add(menu11);
        list1.add(menu12);
        list1.add(menu13);
        list1.add(menu14);
        Menu menu21 = new Menu("10161", "用户管理", "set$/userManage", "");
        Menu menu22 = new Menu("10162", "角色管理", "set$/roleManage", "");
        Menu menu23 = new Menu("10163", "权限管理", "set$/moduleManage", "");
        list2.add(menu21);
        list2.add(menu22);
        list2.add(menu23);


        Menu menu = new Menu("10060", "工作台", "desk$", "home", list1);
        Menu menu2 = new Menu("10062", "设置中心", "set$", "set", list2);
        list.add(menu);
        list.add(menu2);
        return list;
    }
}
