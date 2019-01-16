/**
 * Created by renjp on 2019/1/8.
 */
import React from 'react';
import logo from './logo.png'
import "./index.css"


export default function Logo(props) {
    return(
        <div>
            <div className="logo">
                <div className="text"><img src={logo} alt="logo" className="img"/> ITRJP.COM </div>
            </div>
        </div>
    )
}