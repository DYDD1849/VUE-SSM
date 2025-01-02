<template>
    <div>
        <el-card style="max-width: 480px;">
            <el-form label-width="auto" style="max-width: 600px">
                <el-form-item label="账号">
                    <el-input v-model="TeacherUser.user.account"/>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="TeacherUser.user.password"/>
                </el-form-item>
                <el-form-item label="工号">
                    <el-input v-model="TeacherUser.teacher.tno"/>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="TeacherUser.teacher.name"/>
                </el-form-item>
                <el-form-item label="院系">
                    <el-input v-model="TeacherUser.teacher.college"/>
                </el-form-item>
                <el-form-item label="性别">
                    <el-input v-model="TeacherUser.teacher.sex"/>
                </el-form-item>
                <el-form-item label="课号">
                    <el-input v-model="TeacherUser.teacher.cno"/>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="input">注册</el-button>
                  </el-form-item>
            </el-form>
        </el-card>
    </div>
    </template>
    <script setup>
    import { ref } from 'vue';
    import { useRouter } from 'vue-router';
    import { LogIn } from "@/api/user/login.js";

    
    // 创建响应式数据
    const TeacherUser = ref({ 
        user:{
            account:'',
            password:'',
            role:'2'
        },
        teacher:{
            tno:'',
            name:'',
            college:'',
            sex:'',
            title:'',
            cno:'',
            account:''
        } 
});
    // const rs = ref(null); // 通常这个变量可能不是必需的，除非您有特定的用途
     
    // 获取路由实例
    const router = useRouter();
     
    // 定义登录方法
    const input = async () => {
      try {
        const res = await LogIn(TeacherUser.value);
        console.log(res);
        if (res.data === "1") {
          router.push('/main');
        } else {
          // 可能需要在这里处理登录失败的情况
          console.error('Login failed');
        }
      } catch (error) {
        console.error('An error occurred during login:', error);
      }
    };

    </script>