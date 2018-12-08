'use strict';
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
import {Form, Input, Button, Checkbox, message} from 'antd';
const FormItem = Form.Item;


const Login = React.createClass({
    mixins: [Form.ValueMixin],

    getInitialState() {
        return {
            formData: {
                userName: undefined,
                password: undefined,
                agreement: undefined,
            }
        };
    },

    handleSubmit(e) {
        e.preventDefault();
        message.success('收到表单值~~~ ：' + JSON.stringify(this.state.formData, function(k, v) {
                if (typeof v === 'undefined') {
                    return '';
                }
                return v;
            }));
    },

    render() {
        const formData = this.state.formData;
        return (
			<Form inline onSubmit={this.handleSubmit}>
				<FormItem
					id="userName"
					label="账户：">
					<Input placeholder="请输入账户名" id="userName" name="userName" onChange={this.setValue.bind(this, 'userName')} value={formData.userName} />
				</FormItem>
				<FormItem
					id="password"
					label="密码：">
					<Input type="password" placeholder="请输入密码" id="password" name="password" onChange={this.setValue.bind(this, 'password')} value={formData.password} />
				</FormItem>
				<FormItem>
					<label className="ant-checkbox-inline">
						<Checkbox name="agreement" value={formData.agreement} onChange={this.setValue.bind(this, 'agreement')} /> 记住我
					</label>
				</FormItem>
				<Button type="primary" htmlType="submit">登录</Button>
			</Form>
        );
    }
});



class App extends React.Component {
	render() {
		return (
			<Login />
		)
	}
}



// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

