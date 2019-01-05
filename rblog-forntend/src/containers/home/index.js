/**
 * Created by renjp on 2018/12/26.
 */
import React from 'react';
import {connect} from 'react-redux';
import {Layout, Row, Col,} from 'antd';
import Banner from './Banner';
import './style.css'
import ArticleList from '../list'
import Sidebar from '../sidebar'
import {Route, Switch} from "react-router-dom";
import Detail from '../detail';
import Layouts from '../index'

const {Content} = Layout;

function Home() {
    return (
        <Layouts
            banner="true"
        >

            <Switch>
                <Route exact path="/" component={ArticleList}/>
                <Route path="/detail/:id" component={Detail}/>
            </Switch>


        </Layouts>
    );
}
const mapStateToProps = (state) => {
    return {}
}

const mapDispatchToProps = (dispatch) => {
    return {}
}

export default connect(mapStateToProps, mapDispatchToProps)(Home);