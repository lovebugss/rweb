/**
 * Created by renjp on 2018/12/26.
 */
import React from 'react';
import {BrowserRouter as Router, Route, Link, Switch} from "react-router-dom";
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import Footer from './footer';

import Banner from './home/Banner';
import {Layout, Row, Col,} from 'antd';
import './home/style.css'
import Sidebar from './sidebar'

const {Content} = Layout;
class Layouts extends React.Component {

    render() {
        return (
            <Layout className="layout">
                {/*<Header history={this.props.history}/>*/}
                {this.props.banner && (<Banner/>)}
                <Content style={{padding: '0 50px', marginTop: 12}}>
                    <Row>
                        <Col xs={{span: 24}} sm={24} md={18} lg={18} xl={18} xxl={19}>
                            <div className="main-left">
                                {this.props.children}
                            </div>
                        </Col>
                        <Col xs={0} sm={0} md={6} lg={6} xl={6} xxl={5}>
                            <div className="main-right">
                                <Sidebar/>
                            </div>
                        </Col>
                    </Row>
                </Content>
                <Footer/>
            </Layout>
        )
    }
}

function mapStateToProps(state) {
    return {
        isFetching: state.app.isFetching
    }
}

function mapDispatchToProps(dispatch) {
    return {}
}

export default connect(mapStateToProps, mapDispatchToProps)(Layouts);