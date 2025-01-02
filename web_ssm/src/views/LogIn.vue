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
                <el-button plain @click="dialogVisible = true">
                    注册
                </el-button>
              </el-form-item>
        </el-form>
    </el-card>
</div>
<el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="500"
    :before-close="handleClose"
  >
    <span>请选择你的身份</span>
    <template #footer>
      <div class="dialog-footer">
        
        <el-button type="primary" @click="tostudentreg">
          学生
        </el-button>
        <el-button type="primary" @click="toteacherreg">
          教师
        </el-button>
        <el-button @click="dialogVisible = false">取消</el-button>
      </div>
    </template>
  </el-dialog>
</template>
<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { LogIn } from "@/api/user/login.js";
import { ElMessageBox } from 'element-plus'

const dialogVisible = ref(false)

const handleClose = (done) => {
  ElMessageBox.confirm('Are you sure to close this dialog?')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
}
 
// 创建响应式数据
const user = ref({ account: '', password: '' });
// const rs = ref(null); // 通常这个变量可能不是必需的，除非您有特定的用途
 
// 获取路由实例
const router = useRouter();
 
// 定义登录方法
const input = async () => {
  try {
    const res = await LogIn(user.value);
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
const tostudentreg = async () => {
    router.push('/studentReg');
};
const toteacherreg = async ()=> {
    router.push('/teacherReg');
};
</script>