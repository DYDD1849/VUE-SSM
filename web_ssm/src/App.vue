<template>
  <nav>
    <router-link to="/">Home</router-link>

    <router-link to="/about">About</router-link>
    <ul>
      <li v-for="item in backdata" :key="item.testId">
        {{ item.testId }}
      </li>
    </ul>
  </nav>

  <router-view />

  <el-button type="primary" @click="clickpost">主要按钮</el-button>
</template>
<script>
import { test } from '@/api/test.js'
// import axios from "axios"
import { data } from '@/api/data.js'
export default {
  name: 'App',
  data() {
    return {
      a: { "testId": 3 },
      backdata: null,
    }
  },
  methods: {
    clickpost: function () {

      // let data = {"testId":1}  // 带发送的数据
      // axios.post('http://localhost:80/back_ssm/data', this.a).then((res) => {
      //   console.log(res)
      // }, (error) => {
      //   console.log(error)
      // })
      data(this.a).then((res) => {
        console.log(res)
      }, (error) => {
        console.log(error)
      })
    }
  },
  mounted() {
    test().then(res => {
      this.backdata = res.data;
    })
  }
}
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
