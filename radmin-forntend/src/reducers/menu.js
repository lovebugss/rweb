/**
 * Created by renjp on 2019/1/8.
 */


const initialState = {
    isCollapsed: false,
    theme: "dark",
    menuData: [],
    openKeys: [],

};
// Action Types
export const actionsTypes = {
    MENU_COLLAPSE: "MENU_COLLAPSE",
    INIT_MENU: "INIT_MENU",
    GET_MENU: "GET_MENU",
    CLICK_MENU: "CLICK_MENU",
    CHANGE_THEME: "CHANGE_THEME",
};

// Action Creators
export const actions = {

    menu_collapse: (collapse) => {
        return {
            type: actionsTypes.MENU_COLLAPSE,
            collapse
        }
    },
    change_theme: (theme) => {
        return {
            type: actionsTypes.CHANGE_THEME,
            theme
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
        case actionsTypes.MENU_COLLAPSE:
            return {
                ...state, isCollapsed: !state.isCollapsed
            };
        case actionsTypes.GET_MENU:
            return {
                ...state,
            };
        case actionsTypes.INIT_MENU:
            return {
                ...state, menuData: action.menuData
            };
        case actionsTypes.CHANGE_THEME:
            return {
                ...state, theme: action.theme
            }
        default:
            return state
    }
}

