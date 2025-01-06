<template>
  <el-container class="layout-container-demo" style="height: 100%">
      <el-header style="text-align: right; font-size: 12px">
        <div class="toolbar">
            <el-text class="mx-1" type="primary" size="large" style="margin-right: 50px;">
              {{ teacherData ? teacherData.name : 'Default Name' }}
            </el-text>
            <div class="mb-4">
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
import { useRouter } from 'vue-router';
const router = useRouter();
//退出按钮
const quitAction = async()=>{
  sessionStorage.clear();
  router.push("/");
}

const teacherData = ref(null);
const loadTeacherData = async () => {
  const storedObjectString = sessionStorage.getItem('teacherData');
  if (storedObjectString) {
    teacherData.value = JSON.parse(storedObjectString);
  } else {
    console.warn('sessionStorage 中没有存储 teacherData');
  }
  };
// 立即调用这个函数
loadTeacherData(); // 立即加载数据
</script>
<style scoped>
/* 列表长度end */
.layout-container-demo .el-header {
position: relative;
background-color: var(--el-color-primary-light-7);
color: var(--el-text-color-primary);
}

.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}

</style>