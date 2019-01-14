/**
 * Created by renjp on 2019/1/3.
 */
import {reducer as app} from './app'
import {combineReducers} from 'redux';
import {reducer as authReducer}from './auth'
import {reducer as menuReducer} from './menu'
import {connectRouter} from 'connected-react-router';


const rootReducer = (history) => combineReducers({
    router: connectRouter(history),
    global: app,
    menu: menuReducer,
    auth: authReducer,
});

export default rootReducer;
