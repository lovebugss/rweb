/**
 * Created by renjp on 2019/1/10.
 */
import { post} from '../util/fetch';
import {actions as authActions, actionTypes} from '../reducers/auth';
import {actionsTypes as AppActionTypes} from '../reducers/app';
import {showLoading, hideLoading} from 'react-redux-loading-bar';
import { put, takeEvery, } from 'redux-saga/effects';
import url from '../util/url'

let {setLoginInfo} = authActions;

function* loginSaga(action) {

    try {
        yield put(showLoading())
        yield put({type: AppActionTypes.FETCH_START});
        // 登录
        debugger
        let res = yield post(url.login(), action.values);
        // 登录失败 设置全区state
        if (res.error) {
            debugger
            // yield put(setLoginInfo(res.data));
        } else {
            // 登录成功
            debugger
            yield put(setLoginInfo(res.data.token, res.data.username));
        }

    } catch (Execption) {
        // 登录失败
    }
    finally {
        yield put(hideLoading())
        yield put({type: AppActionTypes.FETCH_END});
    }

}


export default function* login() {
    yield takeEvery(actionTypes.LOGIN, loginSaga);
}