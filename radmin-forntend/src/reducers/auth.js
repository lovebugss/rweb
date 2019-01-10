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
    login: (username, password) => {
        debugger
        return {
            type: actionTypes.LOGIN,
            username,
            password,
        }
    },
    setLoginInfo: (userId, username) => {
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
            debugger
            return {
                ...state, password: action.password, username: action.username
            };
        case actionTypes.LOGIN_DONE:
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
