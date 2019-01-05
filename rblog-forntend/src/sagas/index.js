/**
 * Created by ren on 2018/12/26.
 */
import {fork} from 'redux-saga/effects'
import {articleSaga,loadArticleDetail} from './article'
import { push } from 'connected-react-router';


export default function* rootSaga() {
    yield fork(articleSaga);
    yield fork(loadArticleDetail);
}