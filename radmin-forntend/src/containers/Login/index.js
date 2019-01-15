/**
 * Created by renjp on 2019/1/3.
 */
import React from 'react';
import bg from './bg.jpg';
import {Layout} from "antd";
import style from './style.css';
import LoginFrom from './LoginForm';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import Particles from 'reactparticles.js';
import {Redirect} from "react-router-dom";
import {
    Form, Icon, Input, Button, Checkbox,
} from 'antd';
import {actions as authActions, actionTypes,getLoggedUser} from '../../reducers/auth'


class Login extends React.Component {
    constructor() {
        super();
        this.state = {
            redirectToReferrer: false
        }
    }

    componentWillReceiveProps(nextProps) {
        debugger
        const isLoggedIn = !this.props.user.userId && nextProps.user.userId;
        if (isLoggedIn) {
            this.setState({
                redirectToReferrer: true
            });
        }
    }

    render() {
        const {from} = this.props.location.state || {from: {pathname: "/"}};
        const {redirectToReferrer} = this.state;
        if (redirectToReferrer) {
            return <Redirect to={from}/>;
        }

        return (
            <div className="login-main"
                 style={{
                     backgroundImage: `url(${bg})`,
                     backgroundSize: 'cover',
                     backgroundPosition: 'center',

                 }}
            >
                <Particles id="test" config="particles.json"/>
                {/*<Layout className="login">*/}
                    <LoginFrom
                        login={this.props.login}
                    />
                {/*</Layout>*/}
                <div className="footer">
                    ©2017-2018 ITRJP.COM版权所有
                    <br/>
                    <a href="http://www.miibeian.gov.cn/">冀ICP备17025801号-1</a>
                </div>
            </div>)
    }
}

function mapStateToProps(state) {
    return {
        isFetching: state.global.isFetching,
        user: getLoggedUser(state),
    }
}

function mapDispatchToProps(dispatch) {
    return {
        login: bindActionCreators(authActions.login, dispatch),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Login);