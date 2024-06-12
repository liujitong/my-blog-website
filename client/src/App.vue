<template>
  <div id="app">

    <img alt="Vue logo" src="./assets/logo.png">
    <br>
    <el-radio v-model="radio1" label="1">1</el-radio>
    <el-radio disabled v-model="radio1" label="2">2</el-radio>
    <el-radio v-model="radio2" label="3">3</el-radio>
    <el-radio v-model="radio2" label="4">4</el-radio>
    <h1 v-if="radio1==1">{{radio1}}</h1>
    <h2>{{ radio2 }}</h2>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
  },
  methods: {
  },
  data () {
      return {
        radio1: '1',
        radio2: '3'
      };
    },
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
