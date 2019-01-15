/**
 * Created by renjp on 2019/1/4.
 */
import url from '../util/url'
import {get} from '../util/fetch';
import {put, takeEvery} from 'redux-saga/effects';
import {actions, actionsTypes} from '../reducers/menu';
import {actionsTypes as AppActionTypes} from '../reducers/app';


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