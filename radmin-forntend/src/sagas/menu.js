/**
 * Created by renjp on 2019/1/4.
 */
import {call, put, takeEvery, takeLatest} from 'redux-saga/effects';
import {get} from '../util/fetch';
import {actionsTypes as IndexActionTypes} from '../reducers';
import {showLoading, hideLoading} from 'react-redux-loading-bar';
import {actions,actionsTypes} from '../reducers/menu'


const {init_menus} = actions;

function* getMenus() {
    yield put(showLoading())
    yield put({type: IndexActionTypes.FETCH_START});


    try {
        let res = yield get("http://localhost:8081/api/menu/list");
        yield put(init_menus(res.data));

    } catch (Execption) {

    } finally {
        yield put(hideLoading())
        yield put({type: IndexActionTypes.FETCH_END});
    }
}

export default function* loadMenus() {
    yield takeEvery(actionsTypes.GET_MENU,getMenus)
}