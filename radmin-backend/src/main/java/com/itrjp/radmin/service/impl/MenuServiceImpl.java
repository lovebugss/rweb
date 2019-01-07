package com.itrjp.radmin.service.impl;

import com.itrjp.radmin.bean.Menu;
import com.itrjp.radmin.dao.MenuMapper;
import com.itrjp.radmin.service.MenuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ren on 2018/11/4.
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {
        //原始数据
        List<Menu> rootMenus = menuMapper.selectAll();
        //子菜单
        List<Menu> children = rootMenus.stream()
                .filter((menu) -> menu.getActiveFlag() == 1 && menu.getParentId() != null)
                .sorted(Comparator.comparing(Menu::getOrderNum))
                .collect(Collectors.toList());
        //最终数据
        List<Menu> collect = rootMenus.stream()
                .filter((menu) -> menu.getActiveFlag() == 1 && menu.getParentId() == null)
                .sorted(Comparator.comparing(Menu::getOrderNum))
                .collect(Collectors.toList());
        //查找子菜单
        for (Menu menu : collect) {
            menu.setChildren(getChild(menu.getId(), children));
        }

        return collect;
    }


    /**
     * 递归查找子菜单
     *
     * @param id       id
     * @param rootMenu 要查找的菜单
     * @return
     */
    private List<Menu> getChild(String id, List<Menu> rootMenu) {

        // 子菜单
        List<Menu> childList = new ArrayList<>();
        for (Menu menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(menu.getParentId())) {
                if (menu.getParentId().equals(id)) {
                    childList.add(menu);
                }
            }
        }
        // 把子菜单的子菜单再循环一遍
        for (Menu menu : childList) {// 没有url子菜单还有子菜单

            // 递归
            menu.setChildren(getChild(menu.getId(), rootMenu));

        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList.stream().sorted(Comparator.comparing(Menu::getOrderNum)).collect(Collectors.toList());
    }
}
