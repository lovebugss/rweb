/**
 * Created by renjp on 2018/12/27.
 */
import React from 'react';
import {Card, Icon, Avatar,Tag } from 'antd';

const {Meta} = Card;
function Tags() {

    return(
        <Card
            hoverable="true"
            title="标签分类"
        >
            <Tag color="magenta">Java</Tag>
            <Tag color="red">Spring</Tag>
            <Tag color="volcano">Html</Tag>
            <Tag color="orange">Sql</Tag>

        </Card>
    );
}

export default Tags;