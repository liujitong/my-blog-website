<script src="../main.js"></script>
<template>
    <div v-title data-title="刘纪彤的博客-编辑">
        <Header></Header>
        <div class="edit">
            <el-form v-loading="loading_s" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="标题" prop="title">
                    <el-input v-model="ruleForm.title"></el-input>
                </el-form-item>

                <el-form-item label="摘要" prop="descp">
                    <el-input type="textarea" v-model="ruleForm.descp"></el-input>
                </el-form-item>

                <el-form-item label="内容" prop="content">
                    <mavon-editor v-model="ruleForm.content"></mavon-editor>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="submitForm('ruleForm')">立即发布</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
        <Footer></Footer>
    </div>

</template>
<script>
    import Header from "../components/Header";
    import Footer from "../components/Footer";
    export default {
        data() {
            return {
                ruleForm: {
                    bid: "",
                    title: '',
                    descp: '',
                    content: ''
                },
                loading_s: true,
                rules: {
                    title: [
                        { required: true, message: '请输入标题', trigger: 'blur' },
                        { min: 3, max: 100, message: '长度在 3 到 100 个字符', trigger: 'blur' }
                    ],
                    descp: [
                        { required: true, message: '请输入摘要', trigger: 'blur' },

                    ],
                    content: [
                        { required: true, message: '请输入内容', trigger: 'blur' },
                        
                    ]
                }
            };
        },
        //初始化操作


        components: {
            Header,
            Footer
        },
        methods: {
            async submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        //RuleForm添加uid
                        this.ruleForm.uid = this.$store.getters.getUserInfo.uid;
                        //Created为当前时间戳
                        this.$axios.post('/api/blogs/edit', this.ruleForm).then(res => {
                            console.log(res.data)
                            if (res.data.code == "200") {
                                this.$message({
                                    message: '发布成功',
                                    type: 'success'
                                });
                                this.$router.push('/blog')
                            } else {
                                this.$message({
                                    message: '发布失败',
                                    type: 'error'
                                });
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },

            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            
        },
        created() {
            
            this.ruleForm.bid = this.$route.params.bid;
            console.log(this.ruleForm.bid)
            const blogid = this.$route.params.bid;
            if(this.ruleForm.bid == ''||this.ruleForm.bid == undefined){
                this.loading_s = false;
                return
            }
            const _this = this;

            //调用数据库查询博客详情
            this.$axios.get('/api/blogs/'+blogid).then(res => {
                console.log(res.data)
                this.ruleForm = res.data.data;
                this.ruleForm.descp = res.data.data.descp;
                this.loading_s = false;
                console.log(this.ruleForm)
            }).catch(err => {
                //element-ui的message提示
                this.loading_s = false;
                this.$message.error("获取博客详情失败"+err)
            })
        },
}
</script>
<style scoped>

    .edit {
        margin: 0 auto;        
    }


</style>