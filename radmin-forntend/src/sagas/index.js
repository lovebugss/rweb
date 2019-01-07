/**
 * Created by renjp on 2019/1/3.
 */
import {fork} from 'redux-saga/effects'
import {push} from 'connected-react-router';
import loadMenus from "./menu"


export default function* rootSaga() {
    yield fork(loadMenus)

}