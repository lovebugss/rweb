/**
 * Created by renjp on 2018/12/25.
 */

import React from 'react';
import {
    Layout,
    Menu,
    Breadcrumb,
    Icon,
    Skeleton,
    Switcha,
    List,
    Avatar,
    Button,
    Carousel,
    Timeline,
    Row,
    Col,
    Popover,
} from 'antd';


const {Header, Content, Footer, Sider} = Layout;


export default function Header() {

    return (
        <Header style={{background: '#ffffff'}}>
            <Row>

                <Col xs={24} sm={24} md={5} lg={5} xl={5} xxl={4}>
                    <div className="logo">
                        {/*<p className="text">ITRJP.COM</p>*/}
                        <Logo/>
                        {/*<Demo/>*/}
                    </div>
                    {/*<MinTopBar/>*/}
                </Col>
                <Col xs={0} sm={0} md={19} lg={19} xl={19} xxl={20}>
                    <Menu
                        onClick={this.handleClick}
                        selectedKeys={[this.state.current]}
                        mode="horizontal"
                        // theme="dark"
                        defaultSelectedKeys={['2']}
                        style={{lineHeight: '62px', float: 'right', fontSize: '18px'}}
                    >
                        <Menu.Item key="home">
                            <Link to="/">
                                <Icon type="home"/>首页
                            </Link>
                        </Menu.Item>
                        <Menu.Item key="app">
                            <Link to="time">
                                <Icon type="appstore"/>时间轴
                            </Link>
                        </Menu.Item>
                        <SubMenu title={<span className="submenu-title-wrapper"><Icon type="setting"/>???</span>}>
                            <MenuItemGroup title="Item 1">
                                <Menu.Item key="setting:1">Option 1</Menu.Item>
                                <Menu.Item key="setting:2">Option 2</Menu.Item>
                            </MenuItemGroup>
                            <MenuItemGroup title="Item 2">
                                <Menu.Item key="setting:3">Option 3</Menu.Item>
                                <Menu.Item key="setting:4">Option 4</Menu.Item>
                            </MenuItemGroup>
                        </SubMenu>
                        <Menu.Item key="about">

                            <a href="https://ant.design" target="_blank" rel="noopener noreferrer"><Icon
                                type="solution"/>关于我</a>
                        </Menu.Item>
                    </Menu>
                </Col>
            </Row>


        </Header>

    );
}
