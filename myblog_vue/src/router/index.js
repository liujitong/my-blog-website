/**
 * 路由注册中心
 */

import Vue from 'vue'
import VueRouter from 'vue-router'


//注册页面
import Login from '../views/Login.vue'
import Blog from '../views/Blog.vue'
import BlogEdit from '../views/BlogEdit.vue'
import BlogView from '../views/BlogView.vue'
import Register from '../views/Register.vue'
import ResetPwd from '../views/ResetPwd.vue'
import Person from '../views/Person.vue'

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
    {
      path: '/blog/:bid/edit',
      name: 'BlogEdit',
      component: BlogEdit,
      //添加权限访问，表示只有登录之后才能进行该操作
      meta: {
          requireAuth: true
      }
    },
    {
      path:'/blog/:bid',
      name: 'BlogView',
      component: BlogView,
    },
    {
      path:'/register',
      name: 'Register',
      component: Register
    },
    {
      path:'/Person/:uid',
      name: 'Person',
      component:Person,
      meta: {
          requireAuth: true
      }
    },
    {
      path:'/resetpwd',
      name: 'ResetPwd',
      component: ResetPwd
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
