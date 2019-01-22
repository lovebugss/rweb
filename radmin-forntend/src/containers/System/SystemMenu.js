/**
 * Created by renjp on 2019/1/9.
 */
/**
 * Created by renjp on 2019/1/9.
 */
import React from 'react';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import {actions} from '../../reducers/menu';
import {Breadcrumb, Form, Icon, Layout} from "antd";
import Content from '../../components/Content';
import MenuTable from './MenuTable'

class SystemMenu extends React.Component {

    constructor() {
        super()
    }

    render() {

        const {data} = this.props;
        return (
            <Content
                navList={["aaa", "bb", "cc"]}
            >
                <MenuTable
                    data={data}
                />
            </Content>
        );
    }
}
function mapStateToProps(state) {
    return {
        data: state.menu.menuData,
    }
}
function mapDispatchToProps(dispatch) {
    return {
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(SystemMenu);