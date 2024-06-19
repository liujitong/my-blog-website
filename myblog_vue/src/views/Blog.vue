<template>
    <div>
        <Header></Header>
        <div class="block" v-title data-title="刘纪彤的博客-列表">
            <el-timeline>
                <el-timeline-item :timestamp="blog.created" placement="top" v-for="blog in blogsList" v-loading="loading_S">
                    <el-card>
                        <router-link :to="{name:'BlogView',params:{bid:blog.bid}}">
                            <h4>{{blog.title}}</h4>
                        </router-link>
                        <p>{{blog.descp}}</p>
                    </el-card>
                </el-timeline-item>
            </el-timeline>
        </div>
        
        <el-pagination class="mpage"
                       background
                       layout="prev, pager, next"
                       :current-page="currentPage"
                       :page-size="pageSize"
                       :total="total"
                       @current-change=getBlogsList
        >
        </el-pagination>
        <Footer></Footer>
    </div>
</template>
<script>
import Header from "../components/Header";
import Footer from "../components/Footer";
export default {
    name: "Blog",
    components: {
        Header,
        Footer
    },
    data(){
        return {
            blogsList:{},
            currentPage:1,//当前页
            total : 0,//总数
            pageSize: 5,//每页显示的条数
            loading_S : true
        }
    },
    created(){
        this.getBlogsList(1)
    },
    methods:{
        //实现根据页码获取博客列表
        getBlogsList(currentPage){
            console.log(currentPage)
            this.$axios.get('/api/blogs/list?currentPage='+currentPage).then(res=>{
                console.log(res.data.data)
                this.blogsList=res.data.data.records
                this.currentPage = res.data.data.current
                this.total = res.data.data.total
                this.pageSize = res.data.data.size
                this.loading_S = false
            })
        }
    },

}
</script>
<style scoped>
.mpage {
    margin: 0 auto;
    text-align: center;
}
</style>