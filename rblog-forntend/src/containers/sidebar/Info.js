/**
 * Created by renjp on 2018/12/27.
 */
import React from 'react';
import {Card, Icon, Avatar} from 'antd';

const {Meta} = Card;
function Info() {

    return (
        <Card
            hoverable="true"
            cover={<img alt="example" src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png"/>}
            actions={[
                <a href="https://github.com/lovebugss"><Icon type="github"/></a>,
                <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=979668507&amp;site=qq&amp;menu=yes"><Icon type="qq"/></a>,
                <a href="mailto:r979668507@gmail.com"><Icon type="mail"/></a>,
                <a href=""><Icon type="wechat"/></a>,
            ]}
        >
            <Meta
                avatar={<Avatar size={64} src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"/>}
                title="Card title"
                description="This is the description"
            />
        </Card>
    )
}
export default Info;
