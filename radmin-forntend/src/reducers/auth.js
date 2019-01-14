/**
 * Created by renjp on 2019/1/10.
 */

const initialState = {
    userId: "",
    username: ""
};
// Action Types
export const actionTypes = {
    LOGIN: "AUTH_LOGIN",// 登录
    LOGIN_DONE: "AUTH_LOGIN_DONE",// 登录成功
    LOGOUT: " AUTH_LOGOUT"// 注销

};

// Action Creators
export const actions = {
    login: (values) => {
        return {
            type: actionTypes.LOGIN,
            values,
        }
    },
    setLoginInfo: (userId, username) => {
        debugger
        return {
            type: actionTypes.LOGIN_DONE,
            userId: userId,
            username: username
        }
    },
    logout: () => {
        return {
            type: actionTypes.LOGOUT,

        }
    }
};
// selectors
export const getLoggedUser = state => state.auth;
// Reducer
export function reducer(state = initialState, action) {
    switch (action.type) {
        case actionTypes.LOGIN:
            return {
                ...state, value:action.values
            };
        case actionTypes.LOGIN_DONE:
            debugger
            return {
                ...state, userId: action.userId, username: action.username
            };
        case actionTypes.LOGOUT:
            return {
                ...state, userId: null, username: null
            };
        default:
            return state
    }
}
