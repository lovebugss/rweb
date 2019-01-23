/**
 * Created by renjp on 2019/1/23.
 */
import React from 'react';
import {Table, Divider,Button,Switch} from 'antd';


export default function (props) {
    const dataSource = [
        {
            key: '1',
            id: 1,
            name: '超级管理员',
            status: 1,
        }, {
            key: '2',
            id: 2,
            name: '普通用户',
            status: 1,
        },
        {
            key: '3',
            id: 3,
            name: '至尊用户',
            status: 1,
        },
        {
            key: '4',
            id: 4,
            name: '沙雕用户',
            status: 1,
        }
    ];
    const columns = [{
        title: 'id',
        dataIndex: 'id',
        key: 'id',
    }, {
        title: '名称',
        dataIndex: 'name',
        key: 'name',
    }, {
        title: '状态',
        dataIndex: 'status',
        key: 'status',
        render:()=>(
            <Switch defaultChecked onChange={()=>{

            }} />
        )


    }, {
        title: '操作',
        render: () => {
            return (
                <span>

                      <a href="javascript:;" onClick={() => {

                      }}>修改</a>
                      <Divider type="vertical"/>
                      <a href="javascript:;" className="ant-dropdown-link">
                       删除
                      </a>
                </span>
            )
        }
    }];
    return (
        <div className="role-table">
            <Button onClick={()=>{

            }} type="primary" style={{ marginBottom: 23 }}>
                添加角色
            </Button>
            <Table
                dataSource={dataSource}
                columns={columns}
                bordered
                // scroll={{ y: 300 }}
            />
        </div>
    );
}