/**
 * Created by renjp on 2019/1/8.
 */
import React from 'react';
import ReactMarkdown from 'react-markdown';
import {
    Form, Select, InputNumber, Switch, Radio,
    Slider, Button, Upload, Icon, Rate, Checkbox,
    Row, Col, Input,
} from 'antd';
import SimpleMDE from 'simplemde'
import marked from 'marked'
import highlight from 'highlight.js'
import 'simplemde/dist/simplemde.min.css'

const {Option} = Select;
const {TextArea} = Input;

class Demo extends React.Component {
    handleSubmit = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                console.log('Received values of form: ', values);
                console.log(this.smde.value())
            }
        });
    }

    componentDidMount() {
        this.smde = new SimpleMDE({
            element: document.getElementById('editor').childElementCount,
            autofocus: true,
            autosave: true,
            previewRender: function (plainText) {
                return marked(plainText, {
                    renderer: new marked.Renderer(),
                    gfm: true,
                    pedantic: false,
                    sanitize: false,
                    tables: true,
                    breaks: true,
                    smartLists: true,
                    smartypants: true,
                    highlight: function (code) {
                        return highlight.highlightAuto(code).value;
                    }
                });
            },
        })
    }

    normFile = (e) => {
        if (Array.isArray(e)) {
            return e;
        }
        return e && e.fileList;
    }

    render() {
        const {getFieldDecorator} = this.props.form;
        const formItemLayout = {
            labelCol: {span: 6},
            wrapperCol: {span: 14},
        };
        return (
            <Form onSubmit={this.handleSubmit}>
                <Form.Item
                    {...formItemLayout}
                    label="文章标题"
                >
                    {getFieldDecorator('title', {
                        rules: [{required: true, message: '请输入本文章标题'}],
                    })(
                        <Input placeholder="文章标题"/>
                    )}
                </Form.Item>

                <Form.Item
                    {...formItemLayout}
                    label="文章分类"
                    hasFeedback
                >
                    {getFieldDecorator('select', {
                        rules: [
                            {required: true, message: '请选择一个文章分类'},
                        ],
                    })(
                        <Select placeholder="请选择文章分类">
                            <Option value="china">China</Option>
                            <Option value="usa">U.S.A</Option>
                        </Select>
                    )}
                </Form.Item>

                <Form.Item
                    {...formItemLayout}
                    label="封面"
                    extra=""
                >
                    {getFieldDecorator('upload', {
                        valuePropName: 'fileList',
                        getValueFromEvent: this.normFile,
                    })(
                        <Upload name="logo" action="/upload.do" listType="picture">
                            <Button>
                                <Icon type="upload"/> 上传封面
                            </Button>
                        </Upload>
                    )}
                </Form.Item>

                <Form.Item
                    {...formItemLayout}
                    label="正文"
                >
                    <textarea id="editor"></textarea>
                </Form.Item>

                <Form.Item
                    wrapperCol={{span: 12, offset: 6}}
                >
                    <Button type="primary" htmlType="submit">发布</Button>
                </Form.Item>
            </Form>
        );
    }
}

const WrappedDemo = Form.create({name: 'validate_other'})(Demo);

export default WrappedDemo;