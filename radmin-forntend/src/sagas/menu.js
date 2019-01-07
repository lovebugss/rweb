/**
 * Created by renjp on 2019/1/4.
 */
import {call, put, takeEvery, takeLatest} from 'redux-saga/effects';
import {actionsTypes, actions} from '../reducers/index';
import {get} from '../util/fetch';
import {actionsTypes as IndexActionTypes} from '../reducers'
import {showLoading, hideLoading} from 'react-redux-loading-bar'


const {init_menus} = actions;

function* getMenus() {
    yield put(showLoading())
    yield put({type: IndexActionTypes.FETCH_START});


    try {
        debugger
        let res = yield get("http://localhost:8081/api/menu/list");
        debugger
        yield put(init_menus(Object.assign({},res.data)));

    } catch (Execption) {

    } finally {
        yield put(hideLoading())
        yield put({type: IndexActionTypes.FETCH_END});
    }
}

export default function* loadMenus() {
    yield takeEvery(actionsTypes.GET_MENU,getMenus)
}