/**
 * Created by renjp on 2019/1/8.
 */
import React from 'react';
import Edit from '../Edit';
import Layouts from '../Layouts';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import ArticleManage from '../ArticleManage';
import CommentManage from '../CommentManage';
import Analysis from '../dashboard/analysis';
import SystemMenu from '../System/SystemMenu';
import NotFound from '../../components/NotFound';
import {Route, Switch, Redirect} from "react-router-dom";
import {actions} from '../../reducers/auth'

// 登录验证
function requireAuth(Layout, props) {
    if (false) { // 未登录
        return <Redirect to="/login"/>;
    } else {
        return <Layout  />
    }
}
class Home extends React.Component {
    constructor(props) {
        super(props);
        window.addEventListener("beforeunload", this.handleBeforeUnload);
        const {userId, username} = this.props.user;
        if (!userId || !username) {
            this.restoreLoginInfo();
        }
    }

    componentWillUnmount() {
        window.removeEventListener("beforeunload", this.handleBeforeUnload);
    }

    restoreLoginInfo = () => {
        const userId = sessionStorage.getItem("userId");
        const username = sessionStorage.getItem("username");
        if (userId && username) {
            this.props.setLoginInfo(userId, username);
        }
    };

    handleBeforeUnload = () => {
        const {userId, username} = this.props.user;
        if (userId && username) {
            sessionStorage.setItem("userId", userId);
            sessionStorage.setItem("username", username);
        }
    };

    render() {
        return (
            <div>
                <Layouts {...this.props}>
                    <Switch>
                        {/*<Route path="/" component={props => requireAuth(Layouts, props)}>*/}
                        {/*<Route path="/" component={Layouts}>*/}

                        <Route path="/edit" component={props => requireAuth(Edit, props)}/>
                        <Route path="/dashboard/analysis" component={props => requireAuth(Analysis, props)}/>
                        <Route path="/blog/article" component={props => requireAuth(ArticleManage, props)}/>
                        <Route path="/blog/comment" component={props => requireAuth(CommentManage, props)}/>
                        <Route path="/system/menu" component={props => requireAuth(SystemMenu, props)}/>
                        <Redirect from="" to="/dashboard/analysis"/>
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
            ;
    }
}
function mapStateToProps(state) {
    return {
        user: state.auth,
    }
}
function mapDispatchToProps(dispatch) {
    return {
        setLoginInfo: bindActionCreators(actions.setLoginInfo, dispatch),
    }
}
export default  connect(mapStateToProps, mapDispatchToProps)(Home);