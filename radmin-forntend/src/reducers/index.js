/**
 * Created by renjp on 2019/1/3.
 */
import {combineReducers} from 'redux';
import {loadingBarReducer} from 'react-redux-loading-bar';
import {connectRouter} from 'connected-react-router'

const initialState = {
    isFetching: false,
    isCollapsed: false,
    // key:'home',
    msg: {
        code: 1,
        content: ''
    },
    menuData: []
};
// Action Types
export const actionsTypes = {
    FETCH_START: "FETCH_START",
    FETCH_END: "FETCH_END",
    USER_LOGIN: "USER_LOGIN",
    USER_REGISTER: "USER_REGISTER",
    RESPONSE_USER_INFO: "RESPONSE_USER_INFO",
    SET_MESSAGE: "SET_MESSAGE",
    USER_AUTH: "USER_AUTH",
    MENU_COLLAPSE: 'MENU_COLLAPSE',
    INIT_MENU: "INIT_MENU",
    GET_MENU: "GET_MENU",
};

// Action Creators
export const actions = {
    clear_msg: function () {
        return {
            type: actionsTypes.SET_MESSAGE,
            msgType: 1,
            msgContent: ''
        }
    },
    click_head: (key) => {
        return {
            type: actionsTypes.CLICK_BTN,
            key
        }
    },
    menu_collapse: (collapse) => {
        return {
            type: actionsTypes.MENU_COLLAPSE,
            collapse
        }
    },
    get_menus: () => {
        return {
            type: actionsTypes.GET_MENU,

        }
    },
    init_menus: (menuData) => {
        return {

            type: actionsTypes.INIT_MENU,
            menuData
        }
    }
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
                    type: action.msgType,
                    content: action.msgContent
                }
            };
        case 'CLICK_HEAD':
            return {
                ...state, key: action.key
            };
        case actionsTypes.MENU_COLLAPSE:
            return {
                ...state, isCollapsed: !state.isCollapsed
            }
        case actionsTypes.GET_MENU:
            return {
                ...state,
            }
        case actionsTypes.INIT_MENU:
            return {
                ...state, menuData: state.menuData
            }
        default:
            return state
    }
};

const rootReducer = (history) => combineReducers({
    router: connectRouter(history),
    global: reducer,
    loadingBar: loadingBarReducer,
});

export default rootReducer;
