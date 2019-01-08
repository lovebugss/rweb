/**
 * Created by renjp on 2019/1/4.
 */
import React from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import {
    Layout, Menu, Breadcrumb, Icon,
} from 'antd';
import BaseMenu from './BaseMenu';
import Logo from '../Logo';
import {getFlatMenuKeys} from './SiderMenuUtils';
import {actions} from '../../reducers/menu';
import './index.css'

const {SubMenu} = Menu;
const {Content, Sider, Footer} = Layout;

class SiderMenu extends React.Component {
    constructor(props) {
        super(props)
    }
    componentDidMount(){
        this.props.getMenuData();
    }
    onOpenChange = (openKeys) => {

    }

    render() {
        const {menuData, pathname, collapsed,theme} = this.props;
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

function mapStateToProps(state) {
    return {
        collapsed: state.menu.isCollapsed,
        menuData:state.menu.menuData,
        pathname:state.router.location.pathname,
        theme:state.menu.theme
    }
}
function mapDispatchToProps(dispatch) {
    return {
        getMenuData:bindActionCreators(actions.get_menus,dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(SiderMenu);