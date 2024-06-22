const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
module.exports = {
  
  devServer: {
    host: 'localhost',
    open: true, // 自动打开浏览器
    // 代理配置表，在这里可以配置特定的请求代理到对应的API接口
    // 这里是将/api开头的路由代理到yourip:8089的请求
    //比如 /api/login就是yourip:8089/login
    proxy: {
      '/api': {
        target: 'http://yourip:8089',
        changeOrigin: true,
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  }
}
