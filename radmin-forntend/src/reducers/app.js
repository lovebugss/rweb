/**
 * Created by renjp on 2019/1/3.
 */
import {combineReducers} from 'redux';
import {loadingBarReducer} from 'react-redux-loading-bar';

const initialState = {
    isFetching: false,
    msg: {
        code:0,
        content:"",
        type:"",
    },
};
// Action Types
export const actionsTypes = {
    FETCH_START: "FETCH_START",
    FETCH_END: "FETCH_END",
    SET_MESSAGE: "SET_MESSAGE",
    CLEAR_MESSAGE: "CLEAR_MESSAGE",
};

// Action Creators
export const actions = {
    clearMsg: () => {
        return{
        }
    },
    setMsg: function (type,content,code) {
        return {
            type: actionsTypes.SET_MESSAGE,
            msgType: type,
            content: content,
            code:code
        }
    },
};

// Reducer
export function reducer(state = initialState, action) {
    switch (action.type) {
        case actionsTypes.FETCH_START:
            return {
                ...state, isFetching: true
            };
        case actionsTypes.FETCH_END:
            return {
                ...state, isFetching: false
            };
        case actionsTypes.SET_MESSAGE:
            return {
                ...state,
                isFetching: false,
                msg: {
                    code:action.code,
                    type: action.msgType,
                    content: action.content
                }
            };
        default:
            return state
    }
};