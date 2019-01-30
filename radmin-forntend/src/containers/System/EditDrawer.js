/**
 * Created by renjp on 2019/1/22.
 */
import React from 'react';
import PropTypes from 'prop-types';
import {
    Drawer, Form, Button, Col, Row, Input, Select, DatePicker, Icon,Switch,
} from 'antd';

const {Option} = Select;

class EditDrawer extends React.Component {
    constructor(props) {
        super(props);
    }
    componentDidMount(){
        const {curr} = this.props;
        this.props.form.setFieldsValue({
            name:curr.name
        });
    }

    render() {
        const {getFieldDecorator} = this.props.form;
        return (
            <div>
                <Drawer
                    title="修改菜单"
                    width={480}
                    onClose={this.props.onClose}
                    visible={this.props.visible}
                    style={{
                        overflow: 'auto',
                        height: 'calc(100% - 108px)',
                        paddingBottom: '108px',
                    }}
                >
                    <Form layout="vertical" hideRequiredMark>
                        <Row gutter={16}>
                            <Col span={18}>
                                <Form.Item label="名称">
                                    {getFieldDecorator('name', {
                                        rules: [{required: true, message: '请输入菜单名称'}],
                                    })(<Input placeholder="请输入菜单名称"/>)}
                                </Form.Item>
                            </Col>
                        </Row>

                        <Row gutter={16}>
                            <Col span={18}>
                                <Form.Item label="类型">
                                    {getFieldDecorator('type', {
                                        rules: [{required: true, message: '请选择菜单类型'}],
                                    })(
                                        <Select placeholder="请选择菜单类型">
                                            <Option value="private">节点</Option>
                                            <Option value="public">目录</Option>
                                        </Select>
                                    )}
                                </Form.Item>
                            </Col>
                        </Row>

                        <Row gutter={16}>
                            <Col span={18}>
                                <Form.Item label="地址">
                                    {getFieldDecorator('path', {
                                        rules: [{required: true, message: 'Please choose the approver'}],
                                    })(
                                        <Input placeholder="请输入菜单名称"/>
                                    )}
                                </Form.Item>
                            </Col>
                        </Row>

                        <Row gutter={16}>
                            <Col span={18}>
                                <Form.Item label="状态">
                                    {getFieldDecorator('action', {
                                        rules: [
                                            {
                                                required: true,
                                                message: '去',
                                            },
                                        ],
                                    })(<Switch/>)}
                                </Form.Item>
                            </Col>
                        </Row>
                    </Form>
                    <div
                        style={{
                            position: 'absolute',
                            left: 0,
                            bottom: 0,
                            width: '100%',
                            borderTop: '1px solid #e9e9e9',
                            padding: '10px 16px',
                            background: '#fff',
                            textAlign: 'right',
                        }}
                    >
                        <Button onClick={this.props.onClose} style={{marginRight: 8}}>
                            取消
                        </Button>
                        <Button onClick={this.props.save} type="primary">
                            保存
                        </Button>
                    </div>
                </Drawer>
            </div>
        );
    }
}


export default Form.create()(EditDrawer);