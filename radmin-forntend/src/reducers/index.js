/**
 * Created by renjp on 2019/1/3.
 */
import {combineReducers} from 'redux';
import {loadingBarReducer} from 'react-redux-loading-bar';
import {connectRouter} from 'connected-react-router';
import {reducer as menuReducer} from './menu'
import {reducer as authReducer}from './auth'
import {reducer as app} from './app'


const rootReducer = (history) => combineReducers({
    router: connectRouter(history),
    global: app,
    menu: menuReducer,
    auth: authReducer,
    loadingBar: loadingBarReducer,
});

export default rootReducer;
