<template>
  <div>
    <div v-loading="loading_S">    <el-card>
      <el-descriptions class="margin-top" title="用户信息" :column="2" >
        <template slot="extra">
          <el-button type="primary" v-if="this.$route.params.uid==this.$store.getters.getUserInfo.uid" size="small"  @click="messageHandel">操作</el-button>
        </template>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            账号
          </template>
          {{ this_user.username }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            用户编号
          </template>
          {{ this_user.uid }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-s-custom"></i>
            昵称
          </template>
          {{ this_user.screenName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-message"></i>
            邮件
          </template>
          {{ this_user.mail }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-link"></i>
            网址
          </template>
          {{ this_user.url }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            用户组
          </template>
          <a v-if="this_user.group==='visitor'">访客</a>
          <a v-if="this_user.group==='adminstrator'">管理员</a>
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
  </div>

  <el-dialog
  title="修改个人信息"
  :visible.sync="dialogVisible"
  width="60%"
  :before-close="handleClose">
  <el-form :model="this_user" z ref="form" label-width="150px">
      <div class="updateinfo">
  <div class="canedit">
          <el-form-item label="昵称" prop="screenName">
            <el-input v-model="this_user.screenName"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" prop="mail">
            <el-input v-model="this_user.mail"></el-input>
          </el-form-item>
          <el-form-item label="网址" prop="mail">
            <el-input v-model="this_user.url"></el-input>
          </el-form-item>
          
  </div>
  <div class="notedit">
      <el-form-item label="用户编号" prop="uid">
            <el-input v-model="this_user.uid" disabled></el-input>
          </el-form-item>
          <el-form-item label="账号" prop="username">
            <el-input v-model="this_user.username" disabled></el-input>
          </el-form-item>
  </div>
  </div>
  </el-form>
  <span slot="footer" class="dialog-footer">
    <el-button @click=" dialogVisible=false">取 消</el-button>
    <el-button type="primary" @click="submit">提 交</el-button>
  </span>
 </el-dialog>

</div>
</template>
<script>
export default {
  name: "Person",
  data(){
    return {
      dialogVisible: false,
      loading_S: true,
      this_user:{
        username: "",
        mail: "",
        group: 'not login',
        uid: "",
        url: "",
        screenName: ""
      }
    }
  },
  methods:{
    messageHandel(){
      this.dialogVisible = true;
    },
    handleClose(done){
      this.$confirm('确认关闭？')
      .then(_ => {
        done();
      })
      .catch(_ => {});
    },
    submit(){
      this.$axios.put("http://localhost:8081/users/edit/",this.this_user).then(res1=>{
        if(res1.data.code=="200"){
          this.$message({
            message: "修改成功",
            type: "success"
          });
          this.dialogVisible = false;
        }
      }).catch(err=>{
        this.$message({
          message: "修改失败",
          type: "error"
        });
      })
    }
  },
  created(){
    //根据路由得来的uid，获取用户信息
    const uid = this.$route.params.uid;
    this.$axios.get("http://localhost:8081/users/"+uid).then(res1=>{
      if(res1.data.code=="200"){
        this.$message({
          message: "获取用户信息成功",
          type: "success"
        });
        this.this_user = res1.data.data;
        //设置加载状态
        this.loading_S = false;
      }
      else{
        this.$message({
          message: "获取用户信息失败",
          type: "error"
        });
        //去首页
        this.$router.push("/blog");
      }
    }).catch(err=>{
      console.log(err);
    })
  }
}
</script>
<style scoped>
</style>