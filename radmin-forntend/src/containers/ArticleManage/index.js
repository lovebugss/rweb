/**
 * Created by renjp on 2019/1/9.
 */
import React from 'react';
import {Breadcrumb, Layout} from "antd";
import ArticleTable from './ArticleTable'
import ArticleSearchForm from './ArticleSearchForm'
const {Content,} = Layout;

class ArticleManage extends React.Component {


    render() {
        return (
            <Layout style={{padding: '0 24px 24px'}}>
                <Layout

                >
                    <Breadcrumb style={{margin: '12px 0'}}>
                        <Breadcrumb.Item>主页</Breadcrumb.Item>
                        <Breadcrumb.Item>博客管理</Breadcrumb.Item>
                        <Breadcrumb.Item>文章管理</Breadcrumb.Item>
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
                            <ArticleSearchForm/>
                            <ArticleTable/>
                        </div>

                    </Content>
                </Layout>
            </Layout>
        );
    }
}
export default ArticleManage;