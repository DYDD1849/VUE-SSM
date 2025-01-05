<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-header style="text-align: right; font-size: 12px">
          <div class="searchbar">
                <span>搜索教师</span>
                <el-input
                v-model="input2"
                style="width: 240px"
                placeholder="搜索教师"
                :prefix-icon="Search"
                />
            </div>
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
            <span>{{ managerData ? managerData.account : 'Default Name' }}</span>
          </div>
        </el-header>
        <el-main>
          <el-scrollbar>
            <el-table :data="items">
              <el-table-column prop="tno" label="教工号" width="120" />
              <el-table-column prop="tname" label="姓名" width="120" />
              <el-table-column prop="college" label="院系" width="120"/>
              <el-table-column prop="sex" label="性别" width="120"/>
              <el-table-column prop="title" label="职衔" width="120"/>
              <el-table-column prop="account" label="账号" width="120"/>
            </el-table>
          </el-scrollbar>
        </el-main>
    </el-container>
  </template>
  <script setup>
  import { ref } from 'vue';
  import { teacherTable } from '@/api/main/manager/teacherTable.js';
  
//管理员信息传递
  const managerData = ref(null);
//存储所有老师信息
  const items = ref([]); 
  
// 从 sessionStorage 获取管理员数据，并调用 API
const loadManageData = async () => {
  const storedObjectString = sessionStorage.getItem('managerData');
  if (storedObjectString) {
    managerData.value = JSON.parse(storedObjectString);
    
    // 如果 managerData 有值，则调用 teacherTable API
    if (managerData.value) {
      try {
        const res = await teacherTable();
        if (res && res.data) {
          items.value = res.data; 
          console.log(items);
          
        } else {
          console.warn('API 响应不包含 data 属性');
        }
      } catch (error) {
        console.error('调用 teacherTable 时出错:', error);
      }
    }
  } else {
    console.warn('sessionStorage 中没有存储 managerData');
  }
};

// 立即调用这个函数
loadManageData(); // 立即加载数据
  
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
    margin-right: 800px;
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 100%;
  }
  </style>