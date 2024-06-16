/**
 * 路由注册中心
 */

import Vue from 'vue'
import VueRouter from 'vue-router'


//注册页面
import Login from '../views/Login.vue'
import Blog from '../views/Blog.vue'
import BlogEdit from '../views/BlogEdit.vue'
// import BlogDetail from '../views/BlogDetail.vue'


Vue.use(VueRouter)

const routes = [

    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
      path:'/blog',
      name: 'Blog',
      component:Blog
    },
    {
      path: '/blog/add',
      name: 'BlogAdd',
      component: BlogEdit,
      //添加权限访问，表示只有登录之后才能进行该操作
      meta: {
          requireAuth: true
      }
  },


]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
