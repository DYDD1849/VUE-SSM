<template>
    <div>
        <el-card style="max-width: 480px;">
            <el-form label-width="auto" style="max-width: 600px">
                <!--如果账号存在，会显示提示-->
                <el-text class="mx-1" type="danger" v-model="tip">{{ tip.tips }}</el-text>
                <el-form-item label="账号">
                    <el-input v-model="StudentUser.user.account"/>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="StudentUser.user.password"/>
                </el-form-item>
                <el-form-item label="学号">
                    <el-input v-model="StudentUser.student.sno"/>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="StudentUser.student.name"/>
                </el-form-item>
                <el-form-item label="性别">
                    <el-input v-model="StudentUser.student.sex"/>
                </el-form-item>
                <el-form-item label="学院">
                    <el-input v-model="StudentUser.student.college"/>
                </el-form-item>
                <el-form-item label="专业">
                    <el-input v-model="StudentUser.student.major"/>
                </el-form-item>
                <el-form-item label="手机">
                    <el-input v-model="StudentUser.student.phone"/>
                </el-form-item>
                <el-form-item label="地址">
                    <el-input v-model="StudentUser.student.address"/>
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
    import { studentRegister } from "@/api/user/studentRegister.js";
    const tip =ref({
        tips:''
    })
    
    // 创建响应式数据
    const StudentUser = ref({ 
        user:{
            account:'',
            password:'',
            role:'1'
        },
        student:{
            sno: '',
            name:'',
            account:'',
            sex:'',
            college:'',
            major:'',
            phone:'',
            address:'',
        } 
});
    // const rs = ref(null); // 通常这个变量可能不是必需的，除非您有特定的用途
     
    // 获取路由实例
    const router = useRouter();
     
    // 定义注册方法
    const input = async () => {
      try {
        StudentUser.value.student.account=StudentUser.value.user.account;
        const res = await studentRegister(StudentUser.value);
        console.log(res);
        if (res.data == "1") {
          router.push('/main');
        } else {
          // 可能需要在这里处理登录失败的情况
          console.error('用户注册失败');
          tip.value.tips='账号/学生已存在';
        }
      } catch (error) {
        tip.value.tips='注册时发生错误';
        console.error('注册时发生错误:', error);
      }
    };

    </script>