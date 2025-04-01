<template>
<div>
    <el-card style="max-width: 480px;">
        <el-form label-width="auto" style="max-width: 600px">
            <!--如果账号存在，会显示提示-->
            <el-text class="mx-1" type="danger" v-model="tip">{{ tip.tips }}</el-text>
            <el-form-item label="账号">
                <el-input v-model="user.account"/>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="user.password" type="password"/>
            </el-form-item>
            <!--身份选择-->
            <el-form-item label="身份">
              <el-select
              v-model="user.role"
              clearable
              placeholder="Select"
              style="width: 600px"
              >
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
            <!--身份选择end-->
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
import { studentLogIn,teacherLogIn,managerLogIn } from "@/api/user/login.js";
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
//身份选择
const options = [
  {
    value: '1',
    label: '学生',
  },
  {
    value: '2',
    label: '教师',
  },
  {
    value: '3',
    label: '管理员',
  },
]
//身份选择end

const tip =ref({
        tips:''
    })

// 创建响应式数据
const user = ref({ account: '', password: '',role:'' });
 
// 获取路由实例
const router = useRouter();
 
// 定义登录方法
const input = async () => {
  try {
    var res
    var res2 = await managerLogIn(user.value);
    if (user.value.role=='1'){
      res = await studentLogIn(user.value);
    }
    else if(user.value.role=='2'){
      res = await teacherLogIn(user.value);
    }
    else if(user.value.role=='3'){
      res = await managerLogIn(user.value);
    }
    else
    {
      tip.value.tips='请选择您的身份';
    }
    console.log(res);
    if (Object.keys(res.data).length !== 0 ) {
      if (user.value.role==res2.data.role){
        if (user.value.role=='1'){
          sessionStorage.setItem('studentData', JSON.stringify(res.data));
          router.push('/StudentMain');
        }
        else if(user.value.role=='2'){
          sessionStorage.setItem('teacherData', JSON.stringify(res.data));
          router.push('/TeacherMain');
        }
        else if(user.value.role=='3'){
          sessionStorage.setItem('managerData', JSON.stringify(res.data));
          router.push('/ManagerMain');
        }
      }
      else tip.value.tips='请选择正确的身份';
    } else {
      // 可能需要在这里处理登录失败的情况
      tip.value.tips='账号不存在或密码错误';
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