import React, {Component} from 'react';
import Home from '../Home';
import Login from '../Login';
import CityWrapper from "../../components/CityWrapper"
import {notification} from 'antd';
import {connect} from 'react-redux';
import {actions} from '../../reducers/app';
import {bindActionCreators} from 'redux';
import Loading from '../../components/load';
import {BrowserRouter as Router, Route, Switch, Redirect} from "react-router-dom";

import 'antd/dist/antd.css';


class App extends Component {

    componentDidUpdate() {
        let {msg} = this.props;
        if (msg && msg.code === 0 && msg.content)
            this.openNotification(msg.type, msg.content)

    }

    openNotification(type, message) {
        let that = this;
        notification[type]({
            message: message,
            onClose: () => {
                that.props.clearMsg();
            }
        });
        that.props.clearMsg();
    };

    render() {
        let {isFetching, userId} = this.props;


        userId = userId ? userId : window.sessionStorage.getItem("userId");
        let isLogin = !userId && (<Redirect to="/login"/>);
        return (

            <Router>
                <div>
                    <Switch>

                        <Route path="/login" component={Login}/>
                        {isLogin}
                        {/*<Route  component={props => requireAuth(Index, props)}/>*/}
                        <Route component={Home}/>

                    </Switch>
                    {isFetching && <Loading/>}

                </div>
            </Router>
        )
    }
}

function mapStateToProps(state) {
    return {
        isFetching: state.global.isFetching,
        msg: state.global.msg,
        userId: state.auth.userId,
    }
}

function mapDispatchToProps(dispatch) {
    return {
        clearMsg: bindActionCreators(actions.clearMsg, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(App);
