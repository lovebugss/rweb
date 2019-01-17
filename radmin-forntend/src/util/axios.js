/**
 * Created by renjp on 2019/1/17.
 */
import axios from 'axios';
import {message} from 'antd';

axios.interceptors.request.use(config => {
    return config;
}, err => {
    message.error({message: '请求超时!'});
    return Promise.resolve(err);
})
axios.interceptors.response.use(data => {
    debugger
    if (data.code && data.msg && data.code == 0) {
        message.error({message: data.data.msg});
        return;
    }
    return data;
}, err => {
    debugger
    if (err.response.status == 504 || err.response.status == 404) {
        message.error({message: '服务器被吃了⊙﹏⊙∥'});
    } else if (err.response.status == 403) {
        message.error({message: '权限不足,请联系管理员!'});
    } else {
        message.error({message: '未知错误!'});
    }
    return Promise.resolve(err);
})

let base = '';

export const postRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params,
        transformRequest: [
            function (data) {
                return JSON.stringify(data);
            }
        ],
        headers: {
            'Content-Type': 'application/json'
        }
    });
}
export const uploadFileRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params,
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    });
}
export const putRequest = (url, params) => {
    return axios({
        method: 'put',
        url: `${base}${url}`,
        data: params,
        transformRequest: [function (data) {
            let ret = ''
            for (let it in data) {
                ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
            }
            return ret
        }],
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    });
}
export const deleteRequest = (url) => {
    return axios({
        method: 'delete',
        url: `${base}${url}`
    });
}
export const getRequest = (url) => {
    return axios({
        method: 'get',
        url: `${base}${url}`
    });
}