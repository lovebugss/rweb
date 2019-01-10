/**
 * Created by renjp on 2019/1/3.
 */
import {fork} from 'redux-saga/effects'
import {push} from 'connected-react-router';
import loadMenus from "./menu";
import login from './auth'


export default function* rootSaga() {
    yield fork(loadMenus);
    yield fork(login);

}