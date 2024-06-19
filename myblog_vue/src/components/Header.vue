<script src="../main.js"></script>
<template>
  <div class="content">
    <h3>欢迎来到刘纪彤的博客</h3>
    <div class="block">
      <el-avatar
        :size="100"
        :src="require('../assets/logo.png')"
      ></el-avatar>
    </div>

    <div class="maction">
      <span v-if="user.name!==null">
        <router-link :to="{name:'Person',params:{uid: this.user.uid}}">
                            {{ this.user.name }}
                        </router-link>
      
      </span>
      <span v-else> 
        <router-link :to="{name:'Person',params:{uid: this.user.uid}}">
                            一个不愿意设置昵称的程序员
                        </router-link>
      </span>
      <el-divider  direction="vertical"></el-divider>
      <span v-if="user.group!=='not login'&user.url!==null"><a
          :href="user.url"
        >我的网页</a></span>
        
      <el-divider
        direction="vertical"
        v-if="user.group!=='not login'&user.url!==null"
      ></el-divider>
      <span v-if="user.group!=='not login'&user.mail!==null"><a
          :href="'mailto:'+user.mail">我的邮件</a></span>
      <el-divider
        direction="vertical"
        v-if="user.group!=='not login'&user.mail!==null"
      ></el-divider>
      <span v-if="user.group==='administrator'">我的身份：管理员</span>
      <span v-if="user.group==='visitor'">我的身份：访 客</span>
      <span v-if="user.group==='not login'">我的身份：未登录用户</span>
      <br>

      <span><el-link
          type="primary"
          href="/blog"
        >主页</el-link></span>

      <el-divider direction="vertical"></el-divider>
      <span><el-link
          type="success"
          href="/blog/add"
        >发表博客</el-link></span>

      <span v-show="!haslogin">
        <el-divider direction="vertical"></el-divider>
        <span><el-link
            type="warning"
            href="/login"
          >登录</el-link></span>
        <el-divider direction="vertical"></el-divider>
        <span><el-link
            type="danger"
            href="/register"
          >注册</el-link></span>
      </span>

      <span v-show="haslogin">
        <el-divider
          v-show="haslogin"
          direction="vertical"
        ></el-divider>
        <span><el-link
            type="danger"
            @click="logout"
          >退出</el-link></span>
      </span>

    </div>
  </div>
</template>

<script>

export default {
  name: "Header",
  data () {
    return {
      user: {
        mail: "",
        group: "not login",
        url: "",
        name: "未登录访客",
        uid: "",
      },
      haslogin: false
    }
  },
  //初始化操作
  created () {
    console.log(this.$store.getters.getUserInfo)
    if (this.$store.getters.getUserInfo.username) {
      this.user.mail = this.$store.getters.getUserInfo.mail;
      this.user.group = this.$store.getters.getUserInfo.group;
      this.user.url = this.$store.getters.getUserInfo.url;
      this.user.name = this.$store.getters.getUserInfo.screenName;
      this.user.uid = this.$store.getters.getUserInfo.uid;
      console.log(this.$store.getters.getUserInfo.username)
      this.haslogin = true;
    }
  },
  activated(){
    console.log(this.$store.getters.getUserInfo)
    if (this.$store.getters.getUserInfo.username) {
      this.user.mail = this.$store.getters.getUserInfo.mail;
      this.user.group = this.$store.getters.getUserInfo.group;
      this.user.url = this.$store.getters.getUserInfo.url;
      this.user.name = this.$store.getters.getUserInfo.screenName;
      this.user.uid = this.$store.getters.getUserInfo.uid;
      console.log(this.$store.getters.getUserInfo.username)
      this.haslogin = true;
    }
  },
  //写入方法
  methods: {
    logout () {
      //确认在登陆状态
      if (this.haslogin) {
        this.hasLogin = false;
        //清空用户信息
        this.$store.commit('SET_USERINFO', null);
        //跳转到登录页面
        this.$router.push('/login')
      }
    },

  }
}
</script>

<style scoped>
.content {
  h3 {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px;
  }
  max-width: 100%;
  margin: 0 auto;
  text-align: center;
  /* 增加背景图片，透明度30 */
  background-image: url(../assets/bg.jpg);
  background-size: cover;
  /* 透明度 */
  background-color: rgba(255, 255, 255, 0.3);
}

.maction {
  background-color: rgba(255, 255, 255, 0.5);

  margin-top: 10px;

  border-color: rgba(255, 255, 255, 0.5);

  .el-link {
    font-size: 15px;
  }
}
</style>