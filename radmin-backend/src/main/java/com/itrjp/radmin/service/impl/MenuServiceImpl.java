package com.itrjp.radmin.service.impl;

import com.itrjp.radmin.bean.Menu;
import com.itrjp.radmin.dao.MenuMapper;
import com.itrjp.radmin.service.MenuService;
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
        List<Menu> menus = menuMapper.selectAll();

        //子菜单
        List<Menu> children = menus.stream()
                .filter((menu) -> menu.getActiveFlag() == 1 && menu.getParentId() != null)
                .collect(Collectors.toList());

        List<Menu> collect = menus.stream()
                .filter((menu) -> menu.getActiveFlag() == 1 && menu.getParentId() == null)
                .filter(menu -> {

                    return true;
                })
                .sorted(Comparator.comparing(Menu::getOrderNum))

                .collect(Collectors.toList());


        for (Menu menu : collect) {
            for (Menu child : children) {

                if (menu.getId().equals(child.getParentId())) {
                    List<Menu> childrenList = menu.getChildren();
                    if (childrenList == null) {
                        childrenList = new ArrayList<>();
                    }
                    childrenList.add(child);
                    menu.setChildren(childrenList);
                }
            }
        }


        return collect;
    }


    private void setChildren() {

    }
}
