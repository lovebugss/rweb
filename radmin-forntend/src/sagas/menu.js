/**
 * Created by renjp on 2019/1/4.
 */
import {put, takeEvery} from 'redux-saga/effects';
import {get} from '../util/fetch';
import {actionsTypes as AppActionTypes} from '../reducers/app';
import {showLoading, hideLoading} from 'react-redux-loading-bar';
import {actions, actionsTypes} from '../reducers/menu';
import url from '../util/url'


const {init_menus} = actions;

function* getMenus() {

    try {
        yield put({type: AppActionTypes.FETCH_START});
        let res = yield get(url.getMenuList());
        yield put(init_menus(res.data));

    } catch (Execption) {

    } finally {
        yield put({type: AppActionTypes.FETCH_END});
    }
}

export default function* loadMenus() {
    yield takeEvery(actionsTypes.GET_MENU, getMenus)
}