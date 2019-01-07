/**
 * Created by renjp on 2019/1/3.
 */
import React from 'react';
import QueueAnim from 'rc-queue-anim';
import {Layout} from "antd";
import Particles from 'reactparticles.js';
import style from './style.css';
import bg from './bg.jpg';
import {
    Form, Icon, Input, Button, Checkbox,
} from 'antd';

class NormalLoginForm extends React.Component {
    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
            }
        });
    }

    render() {
        const {getFieldDecorator} = this.props.form;
        return (
            <div className="login">
                <div className="header">

                    <div className="logo">
                        <h2>管理系统</h2>
                    </div>
                    <div className="desc">
                        haha
                    </div>
                </div>


                <Form onSubmit={this.handleSubmit} className="login-form" style={{margin: '0 auto'}}>
                    <Form.Item>
                        {getFieldDecorator('userName', {
                            rules: [{required: true, message: 'Please input your username!'}],
                        })(
                            <Input prefix={<Icon type="user" style={{color: 'rgba(0,0,0,.25)'}}/>}
                                   placeholder="用户名"/>
                        )}
                    </Form.Item>
                    <Form.Item>
                        {getFieldDecorator('password', {
                            rules: [{required: true, message: 'Please input your Password!'}],
                        })(
                            <Input prefix={<Icon type="lock" style={{color: 'rgba(0,0,0,.25)'}}/>} type="password"
                                   placeholder="密码"/>
                        )}
                    </Form.Item>
                    <Form.Item>
                        {getFieldDecorator('remember', {
                            valuePropName: 'checked',
                            initialValue: true,
                        })(
                            <Checkbox>记住我</Checkbox>
                        )}
                        <a className="login-form-forgot" href="">修改密码</a>
                        <Button type="primary" htmlType="submit" className="login-form-button">
                            登录
                        </Button>
                        Or <a href="">注册</a>
                    </Form.Item>
                </Form>

            </div>
        );
    }
}

const WrappedNormalLoginForm = Form.create()(NormalLoginForm);
class Login extends React.Component {
    constructor() {
        super()
    }

    render() {
        return (
            <div className="login-main"
                 // style={{
                 //     backgroundImage: `url(${bg})`,
                 //     backgroundSize: 'cover',
                 //     backgroundPosition: 'center',
                 //
                 // }}
            >
                <Particles id="test" config="particles.json"/>
                {/*<Layout className="login">*/}
                <QueueAnim delay={300}>
                    <WrappedNormalLoginForm/>
                </QueueAnim>
                {/*</Layout>*/}
                <div className="footer">
                    ©2017-2018 ITRJP.COM版权所有
                    <br/>
                    <a href="http://www.miibeian.gov.cn/">冀ICP备17025801号-1</a>
                </div>
            </div>)
    }
}


export default Login;