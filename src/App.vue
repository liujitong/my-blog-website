<template>
  <div id="app">
    <h1>{{radio}}</h1>
    <img alt="Vue logo" src="./assets/logo.png">
    <br>
    <el-radio v-model="radio" label="1">1</el-radio>
    <el-radio v-model="radio" label="2">2</el-radio>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
  }
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
