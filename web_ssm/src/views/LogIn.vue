<template>
<div>
    <el-card style="max-width: 480px;">
        <el-form label-width="auto" style="max-width: 600px">
            <el-form-item label="账号">
                <el-input v-model="user.account"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="user.password"/>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="input">登录</el-button>
                <el-button type="primary" >注册</el-button>
              </el-form-item>
        </el-form>
    </el-card>
</div>
</template>
<script>
import {LogIn} from "@/api/user/login.js";
export default{
    name: 'LogIn',
    data() {
        return {
            user:{account:null,password:null,},
            rs:null,
        }
    },
    methods:{
        input:function(){
            LogIn(this.user).then((res) => {
                console.log(res)
                if(res.data=="1"){
                    this.$router.push('/main');
                }
            }, (error) => {
                console.log(error)
            })
            }
    }
}
</script>
  