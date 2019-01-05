/**
 * Created by renjp on 2018/12/28.
 */
import React from 'react';
import {connect} from 'react-redux';
import {Layout, Timeline, Icon} from 'antd';
import './style.css';
import Layouts from '../index'

const {Content} = Layout;

function Time() {
    return (
        <Layouts>
            <div>
                <Content className="time">
                    <Timeline
                        mode="alternate">
                        <Timeline.Item>Create a services site 2015-09-01</Timeline.Item>
                        <Timeline.Item
                            color="green"
                        >
                            Solve initial network problems 2015-09-01
                        </Timeline.Item>
                        <Timeline.Item
                            dot={<Icon type="clock-circle-o" style={{fontSize: '16px'}}/>}
                        >
                            Sed ut perspiciatis
                            unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem
                            aperiam,
                            eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt
                            explicabo.
                        </Timeline.Item>
                        <Timeline.Item
                            color="red"
                        >
                            Network problems being solved 2015-09-01
                        </Timeline.Item>
                        <Timeline.Item>Create a services site 2015-09-01</Timeline.Item>
                        <Timeline.Item
                            dot={<Icon type="clock-circle-o" style={{fontSize: '16px'}}/>}
                        >
                            Technical testing
                            2015-09-01
                        </Timeline.Item>
                    </Timeline>
                </Content>
            </div>
        </Layouts>
    )
}
const mapStateToProps = (state) => {
    return {}
}

const mapDispatchToProps = (dispatch) => {
    return {}
}
export default connect(mapStateToProps, mapDispatchToProps)(Time);
