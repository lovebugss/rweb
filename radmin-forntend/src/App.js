import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch, Redirect} from "react-router-dom";
import {Layout} from 'antd';
import {connect} from 'react-redux';
import Loading from './components/load';
import Index from './containers/index';
import Login from './containers/login';
import Layouts from './containers/layouts';


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
        let {isFetching} = this.props;
        return (

            <Router>
                <div>
                    <Switch>

                        <Route path="/login" component={Login}/>
                        {/*<Route  component={props => requireAuth(Index, props)}/>*/}
                        <Route  component={Index}/>

                    </Switch>
                    {isFetching && <Loading/>}

                </div>
            </Router>
        )
    }
}

function mapStateToProps(state) {
    return {
        isFetching: state.global.isFetching
    }
}

function mapDispatchToProps(dispatch) {
    return {}
}

export default connect(mapStateToProps, mapDispatchToProps)(App);
