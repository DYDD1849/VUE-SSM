<template>
    <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <div class="toolbar">
            <el-dropdown>
              <el-icon style="margin-right: 8px; margin-top: 1px">
                <setting />
              </el-icon>
            </el-dropdown>
          </div>
        </el-header>
        <el-main>
            <router-view />
        </el-main>
    </el-container>
  </template>
  <script setup>
  import { ref } from 'vue';
  const managerData = ref(null);
  const loadTeacherData = async () => {
    const storedObjectString = sessionStorage.getItem('managerData');
    if (storedObjectString) {
      managerData.value = JSON.parse(storedObjectString);
    } else {
      console.warn('sessionStorage 中没有存储 managerData');
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