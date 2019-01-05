/**
 * Created by renjp on 2018/12/26.
 */
import React from 'react';
import TweenOne from 'rc-tween-one';
import BannerAnim, {Element} from 'rc-banner-anim';
import 'rc-banner-anim/assets/index.css';
import one from '../../static/images/page_bg.jpg';
import two from '../../static/images/bg-03.jpg';
import MediaQuery from 'react-responsive';

const BgElement = Element.BgElement;

function Banner(props) {
    return (
        <BannerAnim prefixCls="banner-user" autoPlay style={{height:props.height}}>
            <Element key="aaa"
                     prefixCls="banner-user-elem"
                     followParallax={{
                         delay: 1000,
                         data: [
                             {id: 'bg', value: 20, bgPosition: '50%', type: ['backgroundPositionX']},
                             {id: 'title', value: 50, type: 'x'},
                             {id: 'content', value: -30, type: 'x'},
                         ],
                     }}
            >
                <BgElement
                    key="bg"
                    className="bg"
                    style={{
                        backgroundImage: `url(${two})`,
                        backgroundSize: 'cover',
                        backgroundPosition: 'center',
                    }}
                    id="bg"
                />
                <TweenOne className="banner-user-title"
                          animation={{y: 30, opacity: 0, type: 'from'}}
                          id="title"
                >
                    我们都在努力奔跑
                </TweenOne>
                <TweenOne className="banner-user-text"
                          animation={{y: 30, opacity: 0, type: 'from', delay: 100}}
                         id="content"
                >
                    我们都是追梦人
                </TweenOne>
            </Element>
            <Element key="bbb"
                     prefixCls="banner-user-elem"
            >
                <BgElement
                    key="bg"
                    className="bg"
                    style={{
                        backgroundImage: `url(${one})`,
                        backgroundSize: 'cover',
                        backgroundPosition: 'center',
                    }}
                />
                <TweenOne className="banner-user-title"
                          animation={{y: 30, opacity: 0, type: 'from',delay: 100}}>
                    Ant Motion Banner
                </TweenOne>
                <TweenOne className="banner-user-text"
                          animation={{y: 30, opacity: 0, type: 'from', delay: 100}}
                >
                    The Fast Way Use Animation In React
                </TweenOne>
            </Element>
        </BannerAnim>
    );

}
export default function () {
    return(
        <div>

            <MediaQuery query="(min-device-width: 1224px)">

                <MediaQuery query="(min-device-width: 1824px)">
                    <Banner height="420px"/>
                </MediaQuery>
                <MediaQuery query="(max-width: 1224px)">
                    <Banner height="360px"/>
                </MediaQuery>
            </MediaQuery>
        </div>

    )
};