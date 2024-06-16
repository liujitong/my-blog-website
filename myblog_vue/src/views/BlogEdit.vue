<template>
    <div>
        <Header></Header>
        <div class="m_content">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="标题" prop="title">
                    <el-input v-model="ruleForm.title"></el-input>
                </el-form-item>

                <el-form-item label="摘要" prop="description">
                    <el-input type="textarea" v-model="ruleForm.description"></el-input>
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
    </div>
</template>
<script>
    import Header from "../components/Header";


    export default {
        data() {
            return {
                ruleForm: {
                    bid: "",
                    title: '',
                    description: '',
                    content: ''
                },
                rules: {
                    title: [
                        { required: true, message: '请输入标题', trigger: 'blur' },
                        { min: 3, max: 100, message: '长度在 3 到 100 个字符', trigger: 'blur' }
                    ],
                    description: [
                        { required: true, message: '请输入摘要', trigger: 'blur' },

                    ],
                    content: [
                        { required: true, message: '请输入内容', trigger: 'blur' },
                        
                    ]
                }
            };
        },
        components: {
            Header
        },
        methods: {
            async submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        this.$axios.post('http://localhost:8081/blog/add', this.ruleForm).then(res => {
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
            }
        }
    }
</script>
<style scoped>
    .m_content {
        margin: 0 auto;
    }
</style>