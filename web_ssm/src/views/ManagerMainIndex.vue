<template>
  <el-container class="layout-container-demo" style="height: 500px">
    <el-aside width="200px">
      <el-scrollbar>
        <el-menu :default-openeds="['1', '3']">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><message /></el-icon>信息管理
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1" @click="goToStudentManage">学生信息</el-menu-item>
              <el-menu-item index="1-2" @click="goToTeacherManage">教师信息</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><icon-menu /></el-icon>成绩管理
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="goToSCManage">学生成绩</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
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
        
          <router-view />
        
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import {ref} from 'vue'
import { Menu as IconMenu, Message, Setting } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router';

const managerData = ref(null);
const LoadManageData = async() => {
  const storedObjectString = sessionStorage.getItem('managerData');
  if (storedObjectString) {
    managerData.value = JSON.parse(storedObjectString);
  } else {
    console.warn('sessionStorage 中没有存储 managerData');
  }
}
LoadManageData();

//路由跳转 学生/教师信息管理/学生成绩
const router = useRouter();
const goToStudentManage = () => {
  router.push('/ManageStudent');
};
const goToTeacherManage = () => {
  router.push('/ManageTeacher');
}
const goToSCManage = () => {
  router.push('/ManageStudentScore');
}
</script>

<style scoped>
.layout-container-demo .el-header {
  position: relative;
  background-color: var(--el-color-primary-light-7);
  color: var(--el-text-color-primary);
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}
.layout-container-demo .el-menu {
  border-right: none;
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