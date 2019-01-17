/**
 * Created by renjp on 2019/1/3.
 */
import React from "react";
import LoginFrom from "./LoginForm";
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {Redirect} from "react-router-dom";
import CityWrapper from "../../components/CityWrapper";
import {Layout} from "antd";
import {actions as authActions, getLoggedUser} from "../../reducers/auth";


class Login extends React.Component {
    constructor() {
        super();
        this.state = {
            redirectToReferrer: false
        }
    }

    componentWillReceiveProps(nextProps) {
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
            >

                <CityWrapper />
                <Layout className="login"
                        style={{backgroundColor: "rgba(0, 0, 0, 0)",}}
                >
                    <LoginFrom
                        login={this.props.login}
                    />
                </Layout>
                <div className="footer">
                    <p>
                        ©2017-2018 ITRJP.COM版权所有
                        <br/>
                        <a href="http://www.miibeian.gov.cn/">冀ICP备17025801号-1</a>

                    </p>

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