/**
 * Created by renjp on 2019/1/23.
 */
import React from 'react';
import {Table, Divider, Button, Switch, Tree,Icon} from 'antd';

const {TreeNode} = Tree;


export default function (props) {

    const treeData = [{
        title: '/',
        key: '0-0',
        children: [{
            title: '0-0-0',
            key: '0-0-0',
            children: [
                {
                    title: 'Dashboard', key: '0-0-0-0',
                    children: [{
                        title: "分析页",key:"0-0-1-0",
                    },{
                        title: "工作台",key:"0-0-2-0",
                    }]
                },
                {title: '写文章', key: '1-0-0-0'},
                {title: '博客管理', key: '2-0-0-0',
                    children: [{
                        title: "文章管理",key:"2-0-1-0",
                    },{
                        title: "评论管理",key:"2-0-2-0",
                    }]
                },
                {title: '系统管理', key: '3-0-0-0',
                    children: [{
                        title: "用户管理",key:"3-0-1-0",
                    },{
                        title: "字典管理",key:"3-0-2-0",
                    },{
                        title:'菜单管理',key:'3-0-3-0'
                    }]
                },
                {title: '个人中心', key: '4-0-0-0'},
            ],
        }]
    }];
    const renderTreeNodes = data => data.map((item) => {
        if (item.children) {
            return (
                <TreeNode title={item.title} key={item.key} dataRef={item} icon={<Icon type="meh-o" />}>
                    {renderTreeNodes(item.children)}
                </TreeNode>
            );
        }
        return <TreeNode {...item} icon={<Icon type="meh-o" />}/>;
    })
    return (
        <div className="user-table">
            <Tree
                showIcon
                checkable

            >
                {renderTreeNodes(treeData)}
            </Tree>
        </div>
    );
}