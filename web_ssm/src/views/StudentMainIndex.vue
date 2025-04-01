<template>
    <el-container class="layout-container-demo" style="height: 100%">
        <el-header style="text-align: right; font-size: 12px">
          <div class="toolbar">
            <div class="mb-4" style="margin-right: 50px;">
              <el-button type="primary" plain @click="gotoChat">邮箱</el-button>
            </div>
            <el-text class="mx-1" type="primary" size="large" style="margin-right: 50px;">
              {{ studentData ? studentData.name : 'Default Name' }}
            </el-text>
            <div class="mb-4" style="margin-right: 50px;">
              <el-button type="primary" plain @click="quitAction">退出</el-button>
            </div>
          </div>
        </el-header>
        <el-main>
          <router-view />
        </el-main>
    </el-container>
</template>
<script setup>
import { ref } from 'vue';
import { studentMain } from '@/api/main/studentMain.js';
import { useRouter } from 'vue-router';

const studentData = ref(null);
const items = ref([]); // 用于存储课程数据的响应式引用

//路由跳转

//退出按钮
const router = useRouter();

    //邮箱

    const gotoChat = async()=> {
    router.push({name:"ChatRoomS"});
    }
const quitAction = async()=>{
  sessionStorage.clear();
  router.push("/");
}

// 尝试从 sessionStorage 获取学生数据，并调用 API
const loadStudentData = async () => {
  const storedObjectString = sessionStorage.getItem('studentData');
  if (storedObjectString) {
    studentData.value = JSON.parse(storedObjectString);
    
    // 如果 studentData 有值，则调用 studentMain API
    if (studentData.value) {
      try {
        const res = await studentMain(studentData.value);
        if (res && res.data) {
          items.value = res.data; 
          console.log(items);
          // 假设 API 返回的数据中有一个 data 属性包含课程列表
        } else {
          console.warn('API 响应不包含 data 属性');
        }
      } catch (error) {
        console.error('调用 studentMain 时出错:', error);
      }
    }
  } else {
    console.warn('sessionStorage 中没有存储 studentData');
  }
};

// 立即调用这个函数
 loadStudentData(); // 立即加载数据
 
</script>
<style scoped>
/* 列表长度end */
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-main {
  padding: 0;
}

.layout-container-demo .toolbar {
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 100%;
    right: 20px;
  }

  .layout-container-demo .searchbar {
    margin-right: 1000px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 100%;
  }
</style>