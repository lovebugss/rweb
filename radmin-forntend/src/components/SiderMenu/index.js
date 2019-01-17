/**
 * Created by renjp on 2019/1/4.
 */
import React from 'react';
import PropTypes from 'prop-types';
import url from '../../util/url'
import {get} from '../../util/fetch';
import Logo from '../Logo';
import BaseMenu from './BaseMenu';
import {
    Layout, Menu, Breadcrumb, Icon,
} from 'antd';
import {getFlatMenuKeys} from './SiderMenuUtils';
import './index.css'

const {SubMenu} = Menu;
const {Sider} = Layout;

class SiderMenu extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            menuData: []
        }
    }
    onOpenChange = (openKeys) => {

    }
    render() {
        const {menuData, pathname, collapsed, theme} = this.props;
        const flatMenuKeys = getFlatMenuKeys(menuData);
        return (
            <Sider
                trigger={null}
                collapsible
                collapsed={collapsed}
                width={240}
            >
                <Logo
                    collapsed={collapsed}
                />
                <BaseMenu
                    flatMenuKeys={flatMenuKeys}
                    menuData={menuData}
                    pathname={pathname}
                    theme={theme}
                />

            </Sider>
        );
    }
}
SiderMenu.propTypes = {
    menuData: PropTypes.array,
    pathname: PropTypes.string,
    collapsed: PropTypes.bool,
    theme: PropTypes.string
}
export default SiderMenu;