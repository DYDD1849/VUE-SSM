<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-header style="text-align: right; font-size: 12px">
          <div class="searchbar">
                  <span>搜索课程</span>
                  <el-input
                  v-model="input2"
                  style="width: 240px"
                  placeholder="搜索我教的课程"
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
          我教的课
          <el-scrollbar>
            <el-table :data="items">
              <el-table-column prop="cname" label="课程名" width="120" />
              <el-table-column prop="cno" label="课程号" width="120" />
              <el-table-column prop="semester" label="学期" width="120"/>
              <el-table-column prop="ctime" label="学时" width="120"/>
              <el-table-column label="操作" width="120">
              <template #default="scope">
                <el-link href="#" @click="handleManage(scope.row)">管理</el-link>
              </template>
            </el-table-column>
            </el-table>
          </el-scrollbar>
        </el-main>
    </el-container>
  </template>
  <script setup>
  import { ref } from 'vue';
  import { ElLink } from 'element-plus';
  import { CourseTable } from '@/api/main/manager/CourseTable.js';
  import { useRouter } from 'vue-router';
  
  const managerData = ref(null);
  const items = ref(); // 用于存储课程数据的响应式引用

  const router = useRouter();
  // 管理链接点击事件处理函数
  const handleManage = (row) => {
    console.log('Managing course:', row);
    
    
    router.push({name: 'ManageStudentScore',params:{ cno:row.cno}});
    // router.push({ name: 'courseManage', params: { courseId: row.cno } });
  };
  // 尝试从 sessionStorage 获取学生数据，并调用 API
  const LoadManageData = async () => {
  const storedObjectString = sessionStorage.getItem('managerData');
  if (storedObjectString) {
    managerData.value = JSON.parse(storedObjectString);
    
    // 如果 teacherData 有值，则调用 teacherMain API
    if (managerData.value) {
      try {
        const res = await CourseTable(managerData.value);
        if (res && res.data) {
          items.value = res.data; 
          console.log(items);
          // 假设 API 返回的数据中有一个 data 属性包含课程列表
        } else {
          console.warn('API 响应不包含 data 属性');
        }
      } catch (error) {
        console.error('调用 teacherMain 时出错:', error);
      }
    }
  } else {
    console.warn('sessionStorage 中没有存储 teacherData');
  }
  };
  
  // 立即调用这个函数
  LoadManageData(); // 立即加载数据

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