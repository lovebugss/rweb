import React, {Component} from 'react';
import {BrowserRouter as Router,} from "react-router-dom";
import { Route, Switch} from "react-router";
import {Layout} from 'antd';
import {connect} from 'react-redux';
import Loading from './components/load';
import Home from './containers/home'
import Time from './containers/time';
import  MessageBoard from './containers/comment';
import Gallery from'./containers/photo';
import Header from './containers/header';
import Detail from './containers/detail'


class App extends Component {

    render() {
        let {isFetching} = this.props;
        return (

            <Router>
                <Layout className="layout">
                    <Header/>
                    <Switch>
                        <Route exact path="/" component={Home}/>
                        <Route path="/detail/:id" component={Detail}/>
                        <Route path="/time" component={Time}/>
                        <Route path="/message" component={MessageBoard}/>
                        <Route path="/photo" component={Gallery}/>
                    </Switch>
                    {isFetching && <Loading/>}

                </Layout>
            </Router>
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

export default connect(mapStateToProps, mapDispatchToProps)(App);
