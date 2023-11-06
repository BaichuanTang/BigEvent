import {createRouter, createWebHistory} from "vue-router";
import Login from "@/views/Login.vue";
import Layout from "@/views/Layout.vue";
import ArticleCategory from "@/views/article/ArticleCategory.vue";
import ArticleManage from "@/views/article/ArticleManage.vue";
import UserInfo from "@/views/user/UserInfo.vue";
import UserAvatar from "@/views/user/UserAvatar.vue";
import UserResetPassword from "@/views/user/UserResetPassword.vue";

const routes = [
  {path: '/login', component: Login},
  {
    path: '/',
    redirect: '/article/manage',
    component: Layout,
    children: [
      {path: '/article/category', component: ArticleCategory},
      {path: '/article/manage', component: ArticleManage},
      {path: '/user/info', component: UserInfo},
      {path: '/user/avatar', component: UserAvatar},
      {path: '/user/resetPassword', component: UserResetPassword},
    ]
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes: routes
})

export default router