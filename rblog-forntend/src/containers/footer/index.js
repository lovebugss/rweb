/**
 * Created by renjp on 2018/12/26.
 */
import React from 'react';
import {Layout} from 'antd';

let {Footer} = Layout;
export default function () {
    return (
        <Footer style={{textAlign: 'center', background: '#333333',color:'#c3c3c3'}}>
            ©2017-2019 ITRJP.COM版权所有<br/> 冀ICP备17025801号-1
        </Footer>
    );
}

