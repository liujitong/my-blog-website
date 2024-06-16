<script src="../main.js"></script>
<template>
    <div>
        <el-container>
            <el-header>
                <h1>登陆页面</h1>
            </el-header>

            <!--登录表单-->
            <el-main>
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="用户名：" prop="username">
                        <el-input v-model="ruleForm.username"></el-input>
                    </el-form-item>

                    <el-form-item label="密码：" prop="password">
                        <el-input type="password" v-model="ruleForm.password"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="submitForm('ruleForm')">立即登录</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-main>

        </el-container>

    </div>
</template>
<script>
    import Header from "../components/Header";
    export default {
        data() {
            return {
                ruleForm: {
                    username: '',
                    password: ''
                },
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            async submitForm(formName) {  
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        this.$axios.post('http://localhost:8081/login', this.ruleForm).then(res => {  
                            console.log(res.data)
                            if (res.data.code =="200") {  
                                this.$message({  
                                    message: '登录成功',  
                                    type: 'success'  
                                })
                                const userInfo = res.data.data
                                console.log(userInfo)
                                _this.$store.commit('SET_USERINFO',userInfo)
                                console.log(_this.$store.getters.getUserInfo)
                                _this.$router.push({path: '/blog'})
                            } else {  
                                this.$message({  
                                    message: '登录失败',  
                                    type: 'error'  
                                })  
                            }
                        }).catch(err => {  
                            console.log(err)  
                        })
                    } else {
                        console.log('表单验证失败')
                        return false;
                    }
                });
            },
resetForm(formName) {  
    // 重置表单  
    this.$refs[formName].resetFields();  
}
        }
    }

</script>
<style scoped>
    .el-header, .el-footer {
        /*background-color: #B3C0D1;*/
        color: #333;
        text-align: center;
        /*line-height: 600px;*/
        height: 100px !important;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        /*background-color: #E9EEF3;*/
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .mlogo {
        height: 100px;
    }

    .demo-ruleForm {
        max-width: 400px;
        margin: 0 auto;
    }

</style>

