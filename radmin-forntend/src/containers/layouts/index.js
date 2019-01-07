/**
 * Created by renjp on 2019/1/4.
 */
import React from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import Header from '../../components/Header';
import SiderMenu from '../../components/SiderMenu';
import {actions} from '../../reducers/index'

import {
    Layout, Menu, Breadcrumb, Icon,
} from 'antd';
import './index.css'

const {SubMenu} = Menu;
const {Content, Sider, Footer} = Layout;


class Layouts extends React.Component {

    constructor(props) {
        super(props);
    }


    render() {
        const {children,collapsed,handleMenuCollapse} = this.props;
        return (
            <div className="layout-container">
                <Layout>
                    <SiderMenu
                        collapsed={collapsed}
                    >
                    </SiderMenu>
                    <Layout>
                        <Header
                            handleMenuCollapse={handleMenuCollapse}
                            collapsed={collapsed}
                        />
                        <Layout>
                            <Content overlay="">
                                {children}
                            </Content>
                            <Footer>
                                aa
                            </Footer>
                        </Layout>
                    </Layout>
                </Layout>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        collapsed: state.global.isCollapsed
    }
}
function mapDispatchToProps(dispatch) {
    return {
        handleMenuCollapse: bindActionCreators(actions.menu_collapse,dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Layouts);