/**
 * Created by renjp on 2019/1/22.
 */
import React from 'react';
import PropTypes from 'prop-types';
import {
    Table, Badge, Menu, Dropdown, Icon, Switch, Divider, Drawer
} from 'antd';
import EditDrawer from './EditDrawer';
class MenuTable extends React.Component {

    constructor() {
        super()
        this.state = {
            visible: false,
            curr: {
                title: "",
                path: "",
                activeFlag: 1,
            }
        }
    }

    onClose = () => {
        this.setState({visible: false, curr: null});
    }
    showDrawer = () => {
        this.setState({
            visible: true,
        });
    }


    render() {

        const columns = [
            {title: '功能', dataIndex: 'name', },
            {
                title: '状态', dataIndex: 'activeFlag' ,
                render: (text, record, index) => (
                    <Switch defaultChecked/>
                )
            },
            {title: '创建时间', dataIndex: 'createTime', },
            {title: '地址', dataIndex: 'path', key: 'id'},
            {title: '创建人', dataIndex: 'createBy',},
            {
                title: '操作',
                render: (text, record) => {
                    return (
                        <span>
                      <a href="javascript:;">新增</a>
                      <Divider type="vertical"/>
                      <a href="javascript:;" onClick={() => {
                          this.setState({
                              visible: true,
                              curr: {
                                  title: record.name,
                                  path: record.url,
                                  activeFlag: record.activeFlag,
                              }
                          });
                      }}>修改 {record.name}</a>
                      <Divider type="vertical"/>
                      <a href="javascript:;" className="ant-dropdown-link">
                       删除
                      </a>
                    </span>
                    );
                }
            },
        ];
        return (
            <div>

                <Table
                    rowKey="id"
                    className="menu-table"
                    columns={columns}
                    dataSource={this.props.data}
                />
                <EditDrawer
                    curr={this.state.curr}
                    visible={this.state.visible}
                    onClose={this.onClose}
                />
            </div>

        );
    }
}
MenuTable.propTypes = {
    data: PropTypes.array,
}
export default MenuTable;
