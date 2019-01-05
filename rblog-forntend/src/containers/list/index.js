/**
 * Created by renjp on 2018/12/27.
 */
import React from 'react';
import {connect,} from 'react-redux';
import {bindActionCreators} from 'redux';
import {actions} from '../../reducers/article'
import {
    Layout,
    Menu,
    Breadcrumb,
    Icon,
    Skeleton,
    Switcha,
    List,
    Avatar,
    Button,
    Carousel,
    Timeline,
    Row,
    Col,
    Popover,
} from 'antd';
import Layouts from '../index'
import {Link,} from "react-router-dom";
const {loadArticles} = actions;

const IconText = ({type, text,theme,twoToneColor}) => (
    <span>
        <Icon type={type} style={{marginRight: 8}} theme={theme} twoToneColor={twoToneColor}/>
        {text}
    </span>
);
class ArticleList extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        this.props.loadArticle();
    }

    render() {
        return (
            // <Layouts banner="true">
            <div style={{background: '#ffffff', padding: '0px 12px 12px'}}>
                {/*<Switcha checked={!loading} onChange={this.onChange}/>*/}

                <List
                    itemLayout="vertical"
                    size="large"
                    dataSource={this.props.listData}
                    pagination={{
                        onChange: (page) => {

                        },
                        pageSize: this.props.pageSize,
                    }}
                    renderItem={item => (
                        <List.Item
                            key={item.id}
                            actions={!this.props.isLoading && [<IconText type="tags" text="java" theme="twoTone" twoToneColor="#eb2f96"/>,
                                <IconText type="user" text={item.createBy} />,
                                <IconText type="eye" text={item.readCount}  theme="twoTone" twoToneColor="#40baff"/>,
                                <IconText type="contacts" text={item.createTime} theme="twoTone" twoToneColor="#40baff"/>]}
                            extra={!this.props.isLoading &&
                            <img width={272} height={168}
                                 style={{height: 'auto', maxWidth: '100%', display: 'block'}}
                                 alt="logo"
                                 src={item.imgUrl}/>}
                        >
                            <Skeleton loading={this.props.isLoading} active avatar>
                                <List.Item.Meta
                                    avatar={<Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png"/>}
                                    title={<Link to={`detail/${item.id}`}>{item.articleTitle}</Link>}
                                    description={item.description}
                                />
                                {item.description}
                            </Skeleton>
                        </List.Item>
                    )}
                />
            </div>
            // </Layouts>
        );
    }

}

const mapStateToProps = (state) => {
    return {

        listData: state.article.dataList,
        pageSize: state.article.pageSize,
        isLoading: state.article.isLoading
    }
};
const mapDispatchToProps = (dispatch) => {
    return {
        loadArticle: bindActionCreators(loadArticles, dispatch),

    }
};

export default connect(mapStateToProps, mapDispatchToProps)(ArticleList);

