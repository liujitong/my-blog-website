import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'

//引入element-ui
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"

Vue.config.productionTip = false
Vue.use(Element)

//让请求携带上浏览器的cookie
axios.defaults.withCredentials=true
Vue.prototype.$axios = axios
//导入permission.js，用户进行前端的权限控制
import "./permission"

//导入mavon-editor，用户Markdown编辑器
import mavonEditor from 'mavon-editor'
//导入所需依赖文件
import "element-ui/lib/theme-chalk/index.css"
//解决Markdown编辑器的图标不出现问题
import "mavon-editor/dist/css/index.css"
Vue.use(mavonEditor)
//标题
Vue.directive('title', {
  inserted: function (el, binding) {
    document.title = el.dataset.title
  }
})


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
