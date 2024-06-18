/**
 * 请求登录验证，如果没有登录，不能访问页面，返回到登录页面
 */
import router from "./router";
import ElementUI from "element-ui";
//路由判断登录，根据路由配置文件的参数
router.beforeEach((to,from,next)=>{
    //判断该路由是否需要登录权限
    //record.meta.requireAuth是获取到该请求中携带的该参数
    if (to.matched.some(record => record.meta.requireAuth)){
        //获取user信息
        let user = JSON.parse(sessionStorage.getItem('UserInfo'))
        console.log(user)
        if (user){
            next()
        }
        else {
            ElementUI.Message.error('请先登录')
            next({path:'/login'})
        }

    }else {
        //如果不需要登录认证，就直接访问
        next()
    }
})