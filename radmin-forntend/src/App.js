import React, {Component} from 'react';
import {Layout} from 'antd';
import {connect} from 'react-redux';
import {actions} from './reducers/app';
import {bindActionCreators} from 'redux';
import Index from './containers/index';
import Login from './containers/login';
import Loading from './components/load';
import Layouts from './containers/layouts';
import ModalDialog from './components/ModalDialog'
import {BrowserRouter as Router, Route, Switch, Redirect} from "react-router-dom";


import 'antd/dist/antd.css';


// 登录验证
function requireAuth(Layout, props) {
    debugger
    if (false) { // 未登录
        return <Redirect to="/login"/>;
    } else {
        return <Layout  />
    }
}

class App extends Component {


    render() {
        const {isFetching,msg} = this.props;
        const errorDialog = msg.code != 0 && (
                <ModalDialog
                    msg={this.props.msg}
                    onClose={this.props.clearMsg}
                />

            );
        return (

            <Router>
                <div>
                    <Switch>

                        <Route path="/login" component={Login}/>
                        {/*<Route  component={props => requireAuth(Index, props)}/>*/}
                        <Route  component={Index}/>

                    </Switch>
                    {errorDialog}
                    {isFetching && <Loading/>}

                </div>
            </Router>
        )
    }
}

function mapStateToProps(state) {
    return {
        isFetching: state.global.isFetching,
        msg:state.global.msg
    }
}

function mapDispatchToProps(dispatch) {
    return {
        clearMsg:bindActionCreators(actions.clearMsg, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(App);
