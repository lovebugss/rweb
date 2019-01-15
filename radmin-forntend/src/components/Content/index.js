/**
 * Created by renjp on 2019/1/9.
 */
import React from 'react';
import {Breadcrumb,  Layout} from "antd";

const {Content,} = Layout;

export default function (props) {

    const {navList} = props;
    let nav = [];
    if (navList) {
        let i=0;
        navList.map(item => {
            nav.push(<Breadcrumb.Item key={i++}>{item}</Breadcrumb.Item>)
        })
    }
    return (
        <Layout style={{padding: '0 24px 24px'}}>
            <Layout

            >
                <Breadcrumb style={{margin: '12px 0'}}>
                    {nav}
                </Breadcrumb>
            </Layout>
            <Layout>
                <Content
                    style={{
                        background: '#fff', padding: 24, margin: 0, minHeight: 280,
                    }}
                >
                    {props.children}
                </Content>
            </Layout>
        </Layout>
    );
};