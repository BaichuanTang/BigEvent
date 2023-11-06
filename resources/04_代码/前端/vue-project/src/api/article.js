/* //导入axios  npm install axios
import axios from 'axios';
//定义一个变量,记录公共的前缀  ,  baseURL
const baseURL = 'http://localhost:8080';
const instance = axios.create({baseURL}) */

import request from '@/util/request.js'

export function articleGetAllService() {
    return request.get('/article/getAll');

}

export function articleSearchService(conditions) {
    return request.get('/article/search', { params: conditions });
}