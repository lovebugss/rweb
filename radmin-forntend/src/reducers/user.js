/**
 * Created by renjp on 2019/1/10.
 */

const initialState = {
    redirectTo: '', // 完成之后跳到哪里
    username: '', // 账号
    pwd: '', // 密码
    pwdConfirm: '', // 确认密码
    type: '', // 用户类型
    msg: '', // 错误消息
    isLogin: false // 是否登录
};
// Action Types
export const actionTypes = {
    REGISTER_SUCCESS: "REGISTER_SUCCESS",// 注册成功
    REGISTER_FAILURE: " REGISTER_FAILURE"//注册失败

};

// Action Creators
export const actions = {
    registerSuccess: (data) => {
        return {
            type: actionTypes.REGISTER_SUCCESS,
            data
        }
    },
    registerFailure: () => {
        return {
            type: actionTypes.REGISTER_FAILURE,

        }
    }
};

// Reducer
export function reducer(state = initialState, action) {
    switch (action.type) {
        case actionTypes.REGISTER_SUCCESS:
            return {
                ...state, ...action.data, redirectTo: '/login'
            }
        case actionTypes.REGISTER_FAILURE:
            return{
                ...state
            }
        default:
            return state
    }
}

