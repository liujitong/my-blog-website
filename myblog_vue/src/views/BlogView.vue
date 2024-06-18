<template>
  <div>
      <Header></Header>
      <div class="mblog">
        <div v-if="ownBlog">
              <el-link icon="el-icon-edit" v-if="ownBlog">
                  <!--携带博客ID跳转到编辑页面，对博客进行修改-->
                  <router-link :to="{name:'BlogEdit',params:{bid: this.blog.bid}}">
                      编辑
                  </router-link>
              </el-link>

              <el-divider direction="vertical"></el-divider>

              <el-link type="danger" @click="messageHandel" v-if="ownBlog">
                      删除
              </el-link>
          </div>
            <p>{{ name }}，你正在浏览的是《{{blog.title}}》</p>
            <p>摘要：{{ blog.descp }}</p>
            <p>发布时间：{{ blog.created }}</p>
            <mavon-editor
                class="markdown"
                :value="blog.content"
                :subfield="false"
                defaultOpen="preview"
                :toolbarsFlag="false"
                :editable="false"
                :scrollStyle="true"
                style="min-height:20px"
            ></mavon-editor>   
      </div>
      <el-dialog
              :title="title"
              :visible.sync="centerDialogVisible"
              width="30%"
              center>
      <span slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="deleteBlog">确 定</el-button>
      </span>
      </el-dialog>
  </div>
</template>
<script>
    // 导入所需依赖
    import Header from "../components/Header";

    export default {
        name: "BlogDetail",
        components: {Header},
        data() {
            return {
                centerDialogVisible: false,
                title:'您确定要删除此条博客吗？',
                blog: {
                    bid: "",
                    uid: "",
                    title: "",
                    descp:"",
                    content: "",
                    created: ""
                },
                ownBlog: false,
                name: ""

            }
        },
        //页面加载函数
        created() {
            //获取import的Header组件中的用户信
            this.name = this.$store.getters.getUserInfo.screenName
            const _this = this;
            const blogid = this.$route.params.bid;
            //调用数据库查询博客详情
            this.$axios.get('http://localhost:8081/blogs/'+blogid).then(res => {
                console.log(res.data.code)
                if(res.data.code !== "200"){
                    this.$message.error("获取博客详情失败")
                    return
                }
                console.log(res.data)
                _this.blog.bid= res.data.data.bid;
                _this.blog.title = res.data.data.title;
                _this.blog.descp = res.data.data.descp;
                _this.blog.content = res.data.data.content;
                _this.blog.uid = res.data.data.uid;
                _this.blog.created = res.data.data.created;
                //created将时间(yyyy-mm-dd-hh-mm-ss)转化成为（yyyy-mm-dd hh:mm:ss）                 
                

                _this.ownBlog = (this.blog.uid === _this.$store.getters.getUserInfo.uid)
                //如果adminirstrator用户登录，也可以编辑
                if(_this.$store.getters.getUserInfo.group === "administrator"){
                    _this.ownBlog = true
                }
            })


        },
        methods:{
            messageHandel(){
                this.centerDialogVisible = true
            },
            deleteBlog(){
                const _this = this
                const blogid = this.blog.bid
                //获取正在登录的用户的uid
                const uid = this.$store.getters.getUserInfo.uid
                this.$axios.get('http://localhost:8081/blogs/delete/'+blogid+'?uid='+uid).then(res=>{
                    if(res.data.code === "200"){
                        this.$message.success("删除成功")
                        _this.$router.push({path: '/blog'})
                    }else{
                        this.$message.error("删除失败")
                    }
                })
        },

    }
}

</script>
<style scoped>
    .mblog {
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
        width: 100%;
        min-height: 760px;
        margin: 10px 15px;
    }
    .el-dialog__body{
        padding: 0 !important
    }
    
</style>