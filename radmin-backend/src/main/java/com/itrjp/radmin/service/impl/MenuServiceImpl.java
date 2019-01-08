package com.itrjp.radmin.service.impl;

import com.itrjp.radmin.bean.Menu;
import com.itrjp.radmin.dao.MenuMapper;
import com.itrjp.radmin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Menu> menus = rootMenus.stream()
                .filter((menu) -> menu.getActiveFlag() == 1 && menu.getParentId() == null)
                .map(menu -> {
                    menu.setChildren(getChild(menu.getId(), children));
                    return menu;
                })
                .sorted(Comparator.comparing(Menu::getOrderNum))
                .collect(Collectors.toList());
        return menus;
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
        List<Menu> childList = rootMenu.stream()

                .filter(menu -> menu.getParentId().equals(id))
                .map(menu -> {
                    menu.setChildren(getChild(menu.getId(), rootMenu));
                    return menu;
                })
                .sorted(Comparator.comparing(Menu::getOrderNum))
                .collect(Collectors.toList());
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
