/**
 * Created by renjp on 2018/12/27.
 */
import {call, put, takeEvery, takeLatest} from 'redux-saga/effects';
import {types, actions} from '../reducers/article';
import {get} from '../util/fetch';
import {actionsTypes as IndexActionTypes} from '../reducers'
import {showLoading, hideLoading} from 'react-redux-loading-bar'

const {loadDone} = actions;

export const delay = ms => new Promise(resolve => setTimeout(resolve, ms))
function* fetchArticle(action) {

    yield put(showLoading())
    yield put({type: IndexActionTypes.FETCH_START});


    // yield call(delay, 2000)
    try {
        let res = yield get("http://localhost:8082/article/list");
        yield put(loadDone(Object.assign({isLoading: false},res)));
    } catch (Execption) {

    } finally {
        yield put(hideLoading())
        yield put({type: IndexActionTypes.FETCH_END});
    }

}



export function* articleSaga(listData) {
    yield takeEvery(types.LOAD, fetchArticle);
};

function* fetchDetail(action) {
    yield put(showLoading())
    yield put({type: IndexActionTypes.FETCH_START});


    try {
        let res = yield get("http://localhost:8082/article/"+action.id);
        yield put(loadDone(Object.assign({isLoading: false},res)));
    } catch (Execption) {

    } finally {
        yield put(hideLoading())
        yield put({type: IndexActionTypes.FETCH_END});
    }
}

export function* loadArticleDetail() {
    yield takeEvery(types.LOAD_DETAIL,fetchDetail)
}

