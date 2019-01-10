/**
 * Created by renjp on 2019/1/8.
 */
import React from 'react';
import Layouts from './layouts'
import {BrowserRouter as Router, Route, Switch, Redirect} from "react-router-dom";
import Edit from './edit';
import Analysis from './dashboard/analysis';
import ArticleManage from './blog/ArticleManage';
import SystemMenu from './system/SystemMenu';
import NotFound from '../components/NotFound';

// 登录验证
function requireAuth(Layout, props) {
    debugger
    if (false) { // 未登录
        return <Redirect to="/login"/>;
    } else {
        return <Layout  />
    }
}

export default function Index() {
    return (
        <div>
            <Layouts>
                <Switch>
                    {/*<Route path="/" component={props => requireAuth(Layouts, props)}>*/}
                    {/*<Route path="/" component={Layouts}>*/}

                    <Route path="/edit" component={props => requireAuth(Edit, props)}/>
                    <Route path="/dashboard/analysis" component={props => requireAuth(Analysis, props)}/>
                    <Route path="/blog/article" component={props => requireAuth(ArticleManage, props)}/>
                    <Route path="/system/menu" component={props => requireAuth(SystemMenu, props)}/>

                    {/*<Route path="/edit" component={Edit}/>*/}
                    {/*<Route path="/dashboard/analysis" component={Analysis}/>*/}
                    {/*<Route path="/blog/article" component={ArticleManage}/>*/}
                    {/*<Route path="/system/menu" component={SystemMenu}/>*/}
                    <Route component={NotFound}/>
                    {/*</Route>*/}
                </Switch>
            </Layouts>
        </div>
    )
}