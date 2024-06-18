<script src="../main.js"></script>
<template>
    <div>
        <el-container>
            <el-header>
                <h1>重置密码</h1>
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

                    <el-form-item label="确认密码" prop ="password_2">
                        <el-input type="password" v-model="ruleForm.password_2"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="submitForm('ruleForm')">重置</el-button>
                        <el-button @click="resetForm('ruleForm')">清空</el-button>
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
                // 重复密码验证
                const pwdAgainCheck = async(rule, value, callback) => {
                if (value.length < 1) {
                    this.changeAgainFlag = 2;
                    return callback(new Error('重复密码不能为空！'));
                } else if(this.ruleForm.password != this.ruleForm.password_2){
                    this.changeAgainFlag = 2;
                    return callback(new Error('两次输入密码不一致！'));
                }else{
                    this.changeAgainFlag = 1;
                    callback()
                }}
            return {
                changeFlag: 0,
                changeAgainFlag: 0,
                ruleForm: {
                    username: '',
                    password: '',
                    password_2:''
                },
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
                    ],
                    password_2:[
                        { required: true, validator: pwdAgainCheck, trigger: 'blur' },
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {  
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        this.$axios.post('http://localhost:8081/changePwd', {
                            username: this.ruleForm.username,
                            password: this.ruleForm.password
                        }).then(res => {
                            if (res.data.code == "200") {
                                this.$message({
                                    message: '密码重置成功',
                                    type: 'success'
                                });
                                this.$router.push('/login');
                            } else {
                                this.$message({
                                    message: res.data.msg,
                                    type: 'error'
                                });
                            }
                        }).catch(err => {
                            this.$message.error("服务端出现问题" + err);
                        });
                    } else {
                        this.$message.error("表单验证失败");
                        return false;
                    }
                });
            },
            resetForm(formName) {  
            // 重置表单  
        this.$refs[formName].resetFields();  
        }
            },

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
    .pwd{   
            /* 右对齐 */
            text-align: right;
        
    }

</style>

