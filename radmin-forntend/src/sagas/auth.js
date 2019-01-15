/**
 * Created by renjp on 2019/1/10.
 */
import url from '../util/url'
import {post} from '../util/fetch';
import {put, takeEvery,} from 'redux-saga/effects';
import {actionsTypes as AppActionTypes,actions } from '../reducers/app';
import {actions as authActions, actionTypes} from '../reducers/auth';

let {setMsg} = actions;
let {setLoginInfo} = authActions;

function* loginSaga(action) {

    try {
        yield put({type: AppActionTypes.FETCH_START});
        // 登录
        debugger
        let res = yield post(url.login(), action.values);
        // 登录失败 设置全区state
        if (res.code === 0) {
             yield put(setMsg("error",res.msg,res.code));
        } else {
            // 登录成功
            debugger
            yield put(setLoginInfo(res.data.token, res.data.username));
        }

    } catch (Execption) {
        // 登录失败
    }
    finally {
        yield put({type: AppActionTypes.FETCH_END});
    }

}


export default function* login() {
    yield takeEvery(actionTypes.LOGIN, loginSaga);
}