<template>
  <el-container class="layout-container-demo" style="height: 500px">
      <el-header style="text-align: right; font-size: 12px">
        <button @click="quitAction">退出</button>
        <div class="toolbar">
          <el-dropdown>
            <el-icon style="margin-right: 8px; margin-top: 1px">
              <setting />
            </el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>View</el-dropdown-item>
                <el-dropdown-item>Add</el-dropdown-item>
                <el-dropdown-item>Delete</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
          <span>{{ teacherData ? teacherData.name : 'Default Name' }}</span>
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

</style>