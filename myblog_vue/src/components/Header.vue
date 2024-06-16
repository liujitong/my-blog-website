<script src="../main.js"></script>
<template>
    <div class="m_content">
        <h3>欢迎来到刘纪彤的博客</h3>
        <div class="block">
            <el-avatar :size="100" src="https://www.mlxkj.xyz/logo.jpg"></el-avatar>
            <br>
            <span>
                {{user.name}}   
            </span>
            <el-divider direction="vertical"></el-divider>
            <span>我的网址：<a :href="user.url">我的web</a></span>
            <el-divider direction="vertical"></el-divider>
            <span>我的邮箱：{{user.mail}}</span>
            <el-divider direction="vertical"></el-divider>
            <span v-if="user.group==='administrator'">我的身份：管理员</span>
            <span v-if="user.group==='visitor'">我的身份：访客</span>
        </div>

        <div class="maction">
            <span><el-link type="primary" href="/blog">主页</el-link></span>

            <el-divider direction="vertical"></el-divider>
            <span><el-link type="success" href="/blog/add">发表博客</el-link></span>

            <span v-show="!haslogin">
                <el-divider direction="vertical"></el-divider>
                <span><el-link type="warning" href="/login">登录</el-link></span>
            </span>

            <span v-show="haslogin">
                <el-divider v-show="haslogin" direction="vertical"></el-divider>
                <span ><el-link type="danger" @click="logout">退出</el-link></span>
            </span>

        </div>
    </div>
</template>

<script>

    export default {
        name: "Header",
        data() {
            return {
                user: {
                    mail:"",
                    group: "visitor",
                    url:"",
                    name:"未登录访客",
                },
                haslogin: false
            }
        },
                //初始化操作
                created(){
                console.log(this.$store.getters.getUserInfo)
                if(this.$store.getters.getUserInfo.username){
                    this.user.mail = this.$store.getters.getUserInfo.mail;
                    this.user.group = this.$store.getters.getUserInfo.group;
                    this.user.url = this.$store.getters.getUserInfo.url;
                    this.user.name = this.$store.getters.getUserInfo.screenName;
                    console.log(this.$store.getters.getUserInfo.username)
                    this.haslogin = true;
                }
            },
        //写入方法
        methods: {
            logout() {
                //确认在登陆状态
                if (this.haslogin) {
                    //清空用户信息
                    this.$store.commit('SET_USERINFO', {});
                    //跳转到登录页面
                    this.$router.push('/login')
                }
            },

    }
}
</script>

<style scoped>
    .m_content {
        max-width: 960px;
        margin: 0 auto;
        text-align: center;
    }

    .maction {
        margin: 10px 0px;
    }
</style>