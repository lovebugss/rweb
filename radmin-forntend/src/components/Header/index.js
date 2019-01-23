/**
 * Created by renjp on 2019/1/4.
 */
import React from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import {
    Layout, Menu, Breadcrumb, Icon, Row, Col,
} from 'antd';
import './index.css'

const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;
const {Header,} = Layout;
function HeaderView(props) {

    return (
        <Header className="layout-header" style={{background: '#fff', padding: 0}}>
            <Icon
                className="trigger"
                type={props.collapsed ? 'menu-unfold' : 'menu-fold'}
                onClick={props.handleMenuCollapse}
            />
            <div
                style={{lineHeight: '64px', float: 'right'}}
            >
                <Menu
                    className="header-menu"
                    style={{lineHeight: '64px'}}
                    mode="horizontal"
                >
                    <Menu.Item key="mail">
                        <Icon type="mail"/>
                    </Menu.Item>
                    <Menu.Item key="app" >
                        <Icon type="appstore"/>
                    </Menu.Item>
                    <SubMenu
                        title={<span className="submenu-title-wrapper"><Icon
                            type="setting"/>admin</span>}>
                        <MenuItemGroup title="">
                            <Menu.Item key="setting:1">个人信息</Menu.Item>
                            <Menu.Item key="setting:2">Option 2</Menu.Item>
                        </MenuItemGroup>
                        <MenuItemGroup title="">
                            <Menu.Item key="setting:3">退出</Menu.Item>
                        </MenuItemGroup>
                    </SubMenu>
                </Menu>
            </div>

        </ Header >
    );
}

export default HeaderView;