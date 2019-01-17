/**
 * Created by renjp on 2019/1/4.
 */
import url from '../util/url'
import {get} from '../util/fetch';
import {getRequest} from '../util/axios'
import {put, takeEvery,takeLatest} from 'redux-saga/effects';
import {actions, actionsTypes} from '../reducers/menu';
import {actionsTypes as AppActionTypes, actions as AppActions} from '../reducers/app';


const {init_menus} = actions;

function* getMenus() {

    try {
        debugger
        yield put({type: AppActionTypes.FETCH_START});
        let res = yield getRequest(url.getMenuList());
        if (res.code === 0) {
            sessionStorage.removeItem("userId")
            yield put(AppActions.setMsg("error", res.msg));
        }
        else {

            yield put(init_menus(res.data));
        }

    } catch (Execption) {

    } finally {
        yield put({type: AppActionTypes.FETCH_END});
    }
}

export default function* loadMenus() {
    yield takeLatest(actionsTypes.GET_MENU, getMenus)
}