/**
 * Created by renjp on 2019/1/8.
 */
import React from "react";
import {Breadcrumb, Form, Icon, Layout} from "antd";
import Demo from "../../components/markdown/demo";
import WrappedDemo from './EditForm'

const {Content,} = Layout;

class Edit extends React.Component {
    constructor() {
        super()
    }

    render() {
        return (
            <div>
                <Layout
                    style={{padding: '0 24px 24px'}}
                >
                    <Breadcrumb style={{margin: '16px 0'}}>
                        <Breadcrumb.Item>主页</Breadcrumb.Item>
                        <Breadcrumb.Item>写文章</Breadcrumb.Item>
                    </Breadcrumb>
                    <Content
                        style={{
                            background: '#fff', padding: 24, margin: 0, minHeight: 280,
                        }}
                    >
                        <WrappedDemo/>
                        {/*<Demo/>*/}
                    </Content>
                </Layout>
            </div>
        )
    }
}
export default Edit;