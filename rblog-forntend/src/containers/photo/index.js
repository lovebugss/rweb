/**
 * Created by renjp on 2018/12/29.
 */
import React from 'react';
import './style.css'
import {Card, Layout} from 'antd';
import {connect} from  'react-redux'
import Masonry from 'react-masonry-component';
import {get,post} from '../../util/fetch'


const {Meta} = Card;
const {Content} = Layout;

//http://demo.htmleaf.com/1808/201808011428/images/item-5.jpg
const url = 'https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/'


function Photo(props) {

    return (
        <div>
            <Card
                className="card"
                hoverable
                style={{width: 260}}
                cover={<img alt={props.alt} src={props.imgUrl}/>}
            >
                <Meta
                    title={props.title}
                    description={props.description}
                />
            </Card>
        </div>
    )
}


const masonryOptions = {
    transitionDuration: 0
};

const imagesLoadedOptions = {background: '.my-bg-image-el'}
const data = [];

class Gallery extends React.Component {

    constructor(props) {

        super(props)
        this.state = {
            dataList: []
        }
    }

    componentDidMount() {
        for (let i = 10; i <= 59; i++) {
            data.push({
                alt: '' + i,
                // imgUrl: 'http://demo.htmleaf.com/1808/201808011428/images/item-'+i+'.jpg',
                imgUrl: 'http://cued.xunlei.com/demos/publ/img/P_1'+i+'.jpg',
                title: 'haha',
                description: 'haha'
            })
        }
         get(url).then((res)=>{
             debugger
        });
        debugger

        this.setState({dataList: data})
    }


    render() {
        const childElements = this.state.dataList.map(function (element) {
            return (
                <div className="image-element-class">
                    <Photo
                        alt={element.alt}
                        imgUrl={element.imgUrl}
                        title={element.title}
                        description={element.description}
                    />
                </div>
            );
        });

        return (
            <Content style={{
                margin: '0px auto',
                width: '93%'
            }}>
                <div>

                    <Masonry
                        className={'my-gallery-class'} // default ''
                        elementType={'div'} // default 'div'
                        options={masonryOptions} // default {}
                        disableImagesLoaded={false} // default false
                        updateOnEachImageLoad={false} // default false and works only if disableImagesLoaded is false
                        imagesLoadedOptions={imagesLoadedOptions} // default {}
                    >
                        {childElements}
                    </Masonry>
                </div>
            </Content>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        // data: state.gallery.dataList
    }
}

const mapDispatchToProps = (dispatch) => {
    return {}
}
export default connect(mapStateToProps, mapDispatchToProps)(Gallery);
