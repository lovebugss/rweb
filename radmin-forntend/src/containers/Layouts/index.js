/**
 * Created by renjp on 2019/1/4.
 */
import React from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import Header from '../../components/Header';
import SiderMenu from '../../components/SiderMenu';
import {actions} from '../../reducers/menu';
import Footer from '../../components/Footer'

import {
    Layout,
} from 'antd';
import './index.css'

const {Content,} = Layout;


function Layouts(props) {
    const {children, collapsed, handleMenuCollapse,} = props;
    return (
        <div className="layout-container">
            <Layout>
                <SiderMenu/>
                <Layout>
                    <Header
                        handleMenuCollapse={handleMenuCollapse}
                        collapsed={collapsed}
                    />
                    <Layout>
                        <Content overlay="">
                            {children}
                        </Content>
                        <Footer/>
                    </Layout>
                </Layout>
            </Layout>
        </div>
    );
}


function mapStateToProps(state) {
    return {
        collapsed: state.menu.isCollapsed,
    }
}
function mapDispatchToProps(dispatch) {
    return {
        handleMenuCollapse: bindActionCreators(actions.menu_collapse, dispatch),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Layouts);