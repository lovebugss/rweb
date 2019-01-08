/**
 * Created by renjp on 2019/1/8.
 */
import React from 'react';
import {
    Layout, Menu, Breadcrumb, Icon,
} from 'antd';

import {BrowserRouter as Router, Route, Switch, Link} from "react-router-dom";
import {urlToList, getMenuMatches} from './SiderMenuUtils'
import styles from './index.css';
import {isUrl} from '../../util/utils';
const {SubMenu} = Menu;
const {Content, Sider, Footer} = Layout;

const getIcon = icon => {
    if (typeof icon === 'string' && isUrl(icon)) {
        return <img src={icon} alt="icon" className={styles.icon}/>;
    }
    if (typeof icon === 'string') {
        return <Icon type={icon}/>;
    }
    return icon;
};
class BaseMenu extends React.Component {
    constructor(porps) {
        super(porps);
    }
    /**
     * 获取子节点
     * @param menuData
     * @param parent
     */
    getNavMenuItems = (menuData, parent) => {
        if (!(menuData || menuData.length == 0)) {
            return [];
        }
        return menuData
            .filter(menu => menu.name && menu.activeFlag === 1)
            .map(menu => this.getChildItem(menu, parent))
            .filter(menu => menu);
    };
    // Get the currently selected menu
    getSelectedMenuKeys = pathname => {
        const {flatMenuKeys} = this.props;
        return urlToList(pathname).map(itemPath => getMenuMatches(flatMenuKeys, itemPath).pop());
    };
    getChildItem = (menu, parent) => {
        // 有子节点
        if (menu.children) {
            const {name} = menu;
            return (
                <SubMenu
                    key={menu.path}
                    title={
                        menu.icon ? (
                            <span>
                                {getIcon(menu.icon)}
                                <span>{name}</span>
                            </span>) : (name)
                    }
                >{this.getNavMenuItems(menu.children, parent)}
                </SubMenu>
            );
        }
        // 没有
        return (
            <Menu.Item key={menu.path}>{this.getMenuItemPath(menu)}</Menu.Item>);

    }
    /**
     * 获取
     * @param menu
     */
    getMenuItemPath = (menu) => {
        const name = menu.name;
        const icon = getIcon(menu.icon);

        // http 开头
        if (/^https?:\/\//.test(menu.path)) {
            return (
                <a href={menu.psht}>
                    {icon}
                    <span>{name}</span>
                </a>
            );
        }
        return (
            <Link
                to={menu.path}
            >
                {icon}<span>{name}</span>
            </Link>
        );
    }

    render() {
        const {menuData, pathname, flatMenuKeys,theme} = this.props;

        let selectedKeys = this.getSelectedMenuKeys(pathname);
        let props = {}

        return (
            <Menu
                theme={theme}
                mode="inline"
                selectedKeys={[...selectedKeys]}
                // openKeys={this.state.openKeys}
                onOpenChange={this.onOpenChange}
                // openKeys={[...selectedKeys]}
            >
                {this.getNavMenuItems(menuData)}
            </Menu>
        );
    }
}

export default BaseMenu;