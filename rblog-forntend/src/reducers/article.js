/**
 * Created by renjp on 2018/12/27.
 */
// Actions
export const types = {
    LOAD: 'article/LOAD',
    LOAD_DETAIL: 'article/detail',
    LOAD_DONE: 'article/LOAD_DON',
    CREATE: 'article/CREATE',
    UPDATE: 'article/UPDATE',
    REMOVE: 'article/REMOVE'
};

const initialState = {
    dataList: [],
    data:{},
    pageSize: 0,
    isLoading: true,
};

// Reducer
export default function reducer(state = initialState, action) {
    switch (action.type) {
        case types.LOAD_DONE:
            return {...state, ...action.data};
        case types.LOAD_DETAIL:
            debugger
            return{...state,...action.id};
        case types.CREATE:
        //...
        case types.UPDATE:
        //...
        case types.REMOVE:
        //...
        default:
            return state;
    }
};

// Action Creators
export const actions = {
    loadArticles: function () {
        return {type: types.LOAD};
    },
    loadDone: function (data) {
        return {type: types.LOAD_DONE, data};
    },
    createArticle: function (article) {
        return {type: types.CREATE, article};
    },
    updateArticle: function (article) {
        return {type: types.UPDATE, article};
    },
    removeArticle: function (article) {
        return {type: types.REMOVE, article};
    },
    loadDetail: function (id) {
        debugger
        return {type: types.LOAD_DETAIL, id}
    }
};

