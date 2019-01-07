/**
 * Created by renjp on 2019/1/4.
 */
import React from 'react';
import {
    Layout, Menu, Breadcrumb, Icon,
} from 'antd';
import logo from './logo.png'
import './index.css'
const {SubMenu} = Menu;
const {Content, Sider, Footer} = Layout;

function SiderMenu(props) {
    return (
        <Sider
            trigger={null}
            collapsible
            collapsed={props.collapsed}
            width={240}
        >
            <div className="logo">
                <div className="text"><img src={logo} className="img"/>{!props.collapsed ? "ITRJP.COM" : ""}</div>
            </div>
            <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                <SubMenu key="sub1" title={<span><Icon type="appstore"/><span>Dashboard</span></span>}>
                    <Menu.Item key="5">分析页</Menu.Item>
                    <Menu.Item key="6">监控页</Menu.Item>
                    <Menu.Item key="6">工作台</Menu.Item>
                </SubMenu>
                <Menu.Item key="1">
                    <Icon type="edit" />
                    <span>写文章</span>
                </Menu.Item>
                <Menu.Item key="2">
                    <Icon type="video-camera"/>
                    <span>nav 2</span>
                </Menu.Item>
                <Menu.Item key="3">
                    <Icon type="upload"/>
                    <span>nav 3</span>
                </Menu.Item>
                <SubMenu key="sub1" title={<span><Icon type="appstore"/><span>博客管理</span></span>}>
                    <Menu.Item key="5">Option 5</Menu.Item>
                    <Menu.Item key="6">Option 6</Menu.Item>
                    <SubMenu key="sub3" title="Submenu">
                        <Menu.Item key="7">Option 7</Menu.Item>
                        <Menu.Item key="8">Option 8</Menu.Item>
                    </SubMenu>
                </SubMenu>

                <SubMenu key="sub2" title={<span><Icon type="mail"/><span>系统设置</span></span>}>

                </SubMenu>
                <SubMenu key="sub3" title={<span><Icon type="appstore"/><span>个人中心</span></span>}>
                    <Menu.Item key="5">Option 5</Menu.Item>
                    <Menu.Item key="6">Option 6</Menu.Item>
                    <SubMenu key="sub4" title="Submenu">
                        <Menu.Item key="7">Option 7</Menu.Item>
                        <Menu.Item key="8">Option 8</Menu.Item>
                    </SubMenu>
                </SubMenu>
            </Menu>

        </Sider>
    );
}
export default SiderMenu;