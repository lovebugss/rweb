/**
 * Created by renjp on 2019/1/2.
 */
import React from 'react';
import {connect} from 'react-redux';
import remark from 'remark'
import remark2react  from 'remark-react';
import reactRenderer from 'remark-react'
import Layouts from '../index'
import {bindActionCreators} from 'redux';
import {actions} from '../../reducers/article'
import marked from 'marked';
import hljs from 'highlight.js';
import  ReactMarkdown from 'react-markdown'
import htmlParser  from 'react-markdown/plugins/html-parser'


import style from './style.css'
import  './marked.css'
// import  './markdown.css'

class Detail extends React.Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
        debugger
        this.props.getDetail(this.props.match.params.id);
    }

    getMarkdownText(content) {
        var rawMarkup = marked(content, {sanitize: true});
        return {__html: rawMarkup};
    }

    componentWillMount() {
        // marked相关配置
        marked.setOptions({
            renderer: new marked.Renderer(),
            gfm: true,
            tables: true,
            breaks: true,
            pedantic: false,
            sanitize: true,
            smartLists: true,
            smartypants: false,
            highlight: function (code) {
                return hljs.highlightAuto(code).value;
            },
        });
    }

    render() {
        return (
            <Layouts>
                <div className="detail">
                    <div className={style.header}>
                        <h1>{this.props.detail.articleTitle}</h1>
                    </div>
                    <div className="main">
                        {/*<div id='preview' className={style.content}>*/}
                        {/*<div className="markdown_body">*/}
                        {/*{remark().use(remark2react).processSync(this.props.detail.content).contents}*/}
                        {/*</div>*/}
                        {/*</div>*/}
                        <div className="content">
                            {/*<div*/}
                            {/*id="content"*/}
                            {/*className="article-detail"*/}
                            {/*dangerouslySetInnerHTML={{*/}
                            {/*__html: this.props.detail.content ? marked(this.props.detail.content) : null,*/}
                            {/*}}*/}
                            {/*/>*/}
                            {/*{this.props.detail.content}*/}
                            {/*<div dangerouslySetInnerHTML={{__html:marked(this.props.detail.content ? marked(this.props.detail.content) : "")}} />*/}
                            {/*{marked(this.props.detail.content ? marked(this.props.detail.content) : "")}*/}
                            <ReactMarkdown
                                source={this.props.detail.content}
                                escapeHtml={false}
                                skipHtml={false}
                                sourcePos={false}
                                // astPlugins={[parseHtml]}
                            />
                            <div>
                                {/*{remark().use(remark2react).processSync(this.props.detail.content).contents}*/}
                                {/*{this.props.detail.content}*/}
                            </div>
                        </div>
                    </div>
                </div>
            </Layouts>
        );
    }
}


const mapStateToProps = (state) => {
    return {
        detail: state.article.data,
        // connect:state.article.data.content


    }
}

const mapDispatchToProps = (dispatch) => {
    debugger
    return {
        getDetail: bindActionCreators(actions.loadDetail, dispatch)
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(Detail);