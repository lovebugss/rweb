/**
 * Created by renjp on 2019/1/18.
 */
import React from 'react';
import {
    Form, Row, Col, Input, Button, Icon,
} from 'antd';
import './style.css'


class CommentSearchForm extends React.Component {
    state = {
        expand: false,
    };

    // To generate mock Form.Item
    getFields() {
        const count = this.state.expand ? 10 : 6;
        const {getFieldDecorator} = this.props.form;
        const children = [];
        for (let i = 0; i < 10; i++) {
            children.push(
                <Col span={8} key={i} style={{display: i < count ? 'block' : 'none'}}>
                    <Form.Item label={`Field ${i}`}>
                        {getFieldDecorator(`field-${i}`, {
                            rules: [{
                                required: true,
                                message: 'Input something!',
                            }],
                        })(
                            <Input placeholder="placeholder"/>
                        )}
                    </Form.Item>
                </Col>
            );
        }
        return children;
    }

    handleSearch = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            console.log('Received values of form: ', values);
        });
    }

    handleReset = () => {
        this.props.form.resetFields();
    }

    toggle = () => {
        const {expand} = this.state;
        this.setState({expand: !expand});
    }

    render() {
        return (
            <Form
                className="ant-advanced-search-form"
                onSubmit={this.handleSearch}
                style={{padding: "24px"}}
            >
                <Row gutter={24}>
                    {this.getFields()}
                </Row>
                <Row>
                    <Col span={24} style={{textAlign: 'right'}}>
                        <Button type="primary" htmlType="submit">查询</Button>
                        <Button style={{marginLeft: 8}} onClick={this.handleReset}>
                            清除
                        </Button>
                        <a style={{marginLeft: 8, fontSize: 12}} onClick={this.toggle}>
                            更多 <Icon type={this.state.expand ? 'up' : 'down'}/>
                        </a>
                    </Col>
                </Row>
            </Form>
        );
    }
}


function SearchForm(props) {
    const toggle = () => {

    }

    const {handleSearch,} = props;

    return (
        <Form
            className="ant-advanced-search-form"
            onSubmit={this.handleSearch}
            style={{padding: "24px"}}
        >
            <Row gutter={24}>
                {this.getFields()}
            </Row>
            <Row>
                <Col span={24} style={{textAlign: 'right'}}>
                    <Button type="primary" htmlType="submit">查询</Button>
                    <Button style={{marginLeft: 8}} onClick={this.handleReset}>
                        清除
                    </Button>
                    <a style={{marginLeft: 8, fontSize: 12}} onClick={this.toggle}>
                        更多 <Icon type={this.state.expand ? 'up' : 'down'}/>
                    </a>
                </Col>
            </Row>
        </Form>
    );
}

export default Form.create({name: 'advanced_search'})(CommentSearchForm);
