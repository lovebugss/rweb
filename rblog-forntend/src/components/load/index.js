/**
 * Created by renjp on 2018/12/26.
 */
import React from 'react';

import {Spin, Icon} from 'antd';
import style from './style.css';

const antIcon = <Icon type="sync" style={{fontSize: 24}} spin/>;
export default  () => (
    <div className="container">
        <Spin indicator={antIcon}/>
    </div>
);