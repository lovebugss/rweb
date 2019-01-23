/**
 * Created by renjp on 2019/1/23.
 */
import React from 'react';

import {Row,Col } from 'antd';

import RoleTable from './RoleTable';
import UserTable from './UserTable'
import MenuTree from './MenuTree'



class UserManage extends React.Component{
    constructor(){
        super()
    }
    render(){
        return(
            <div className="user-manage">
                <Row>
                    <Col span={8}><RoleTable/></Col>
                    <Col span={8}><UserTable/></Col>
                    <Col span={8}><MenuTree/></Col>



                </Row>

            </div>
        );
    }
}

export default UserManage;