/**
 * Created by renjp on 2019/1/16.
 */
/**
 * Created by renjp on 2019/1/9.
 */
import React, {Component} from 'react';
import {Breadcrumb, Layout} from "antd";
import CommentTable from './CommentTable'
import CommentSearchForm from "./CommentSearchForm";


const {Content,} = Layout;

class CommentManage extends Component {


    render() {
        return (
            <Layout style={{padding: '0 24px 24px'}}>
                <Layout

                >
                    <Breadcrumb style={{margin: '12px 0'}}>
                        <Breadcrumb.Item>主页</Breadcrumb.Item>
                        <Breadcrumb.Item>博客管理</Breadcrumb.Item>
                        <Breadcrumb.Item>评论管理</Breadcrumb.Item>
                    </Breadcrumb>
                    <h2></h2>
                </Layout>
                <Layout>
                    <Content
                        style={{
                            background: '#fff', padding: 24, margin: 0, minHeight: 280,
                        }}
                    >
                        <div>
                            <CommentSearchForm/>
                            <CommentTable/>
                        </div>

                    </Content>
                </Layout>
            </Layout>
        )
            ;
    }
}
export default CommentManage;