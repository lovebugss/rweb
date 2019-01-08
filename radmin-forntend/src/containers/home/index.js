/**
 * Created by renjp on 2019/1/3.
 */
import React from 'react';
import Layouts from '../layouts'
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Edit from '../edit'
import Analysis from '../dashboard/analysis'

export default function () {
    return(
        <div>
            <Layouts>
                <Switch>
                    <Route path="/edit" component={Edit}/>
                    <Route path="/dashboard/analysis" component={Analysis}/>

                </Switch>
            </Layouts>
        </div>
    )
}