/**
 * Created by renjp on 2019/1/4.
 */
import {call, put, takeEvery, takeLatest} from 'redux-saga/effects';
import {types, actions} from '../reducers/article';
import {get} from '../util/fetch';
import {actionsTypes as IndexActionTypes} from '../reducers'
import {showLoading, hideLoading} from 'react-redux-loading-bar'