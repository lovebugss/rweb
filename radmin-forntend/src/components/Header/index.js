/**
 * Created by renjp on 2019/1/4.
 */
/**
 * Created by renjp on 2019/1/4.
 */
import React from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import {
    Layout, Menu, Breadcrumb, Icon,
} from 'antd';

import './index.css'

const {Header,} = Layout;
function HeaderView(props) {
    return (
        <Header className="layout-header" style={{background: '#fff', padding: 0}}>
            <Icon
                className="trigger"
                type={props.collapsed ? 'menu-unfold' : 'menu-fold'}
                onClick={props.handleMenuCollapse}
            />
        </Header>
    );
}

export default HeaderView;