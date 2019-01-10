/**
 * Created by renjp on 2019/1/10.
 */
import React from 'react';
import {Layout} from "antd";
import style from './style.css';
import {
    Form, Icon, Input, Button, Checkbox,
} from 'antd';

class NormalLoginForm extends React.Component {
    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                debugger
                this.props.login(values.username,values.password);
            }
        });
    }
    render() {
        const {getFieldDecorator} = this.props.form;
        return (
            <div className="login">
                <div className="header">

                    <div className="logo" style={{backGround:"#fff"}}>
                        <h2>管理系统</h2>
                    </div>
                    <div className="desc">
                        haha
                    </div>
                </div>


                <Form onSubmit={this.handleSubmit} className="login-form" style={{margin: '0 auto'}}>
                    <Form.Item>
                        {getFieldDecorator('username', {
                            rules: [
                                {required: true, message: '请输入用户名'},
                                {min: 5, message: "用户名请不少于5位"},
                                {max: 18, message: "用户名请不小于18位"},
                            ],
                        })(
                            <Input prefix={<Icon type="user" style={{color: 'rgba(0,0,0,.25)'}}/>}
                                   placeholder="用户名"/>
                        )}
                    </Form.Item>
                    <Form.Item>
                        {getFieldDecorator('password', {
                            rules: [
                                {required: true, message: '请输入密码'},
                                {min: 5, message: "密码请不少于5位"},
                                {max: 18, message: "密码请勿大于18位"},
                                {whitespace: true, message: "请勿包含空格"},
                            ],
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

export default Form.create()(NormalLoginForm);
