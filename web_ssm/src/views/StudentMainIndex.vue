<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-header style="text-align: right; font-size: 12px">
            
            
            <div class="searchbar">
                <span>搜索课程</span>
                <el-input
                v-model="input2"
                style="width: 240px"
                placeholder="搜索你的课程"
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
            <span>{{ studentData ? studentData.name : 'Default Name' }}</span>
          </div>
        </el-header>
        <el-main>
          <el-scrollbar>
            <el-table :data="item">
              <el-table-column prop="cno" label="课程号" width="120" />
              <el-table-column prop="cname" label="课程名" width="120" />
              <el-table-column prop="credit" label="学分" width="120"/>
              <el-table-column prop="semester" label="学期" width="120"/>
              <el-table-column prop="ctime" label="学时" width="120"/>
              <el-table-column prop="sscore" label="成绩" width="120"/>
              <el-table-column prop="name" label="教师" width="120"/>
            </el-table>
          </el-scrollbar>
        </el-main>
    </el-container>
</template>
<script setup>
import { ref,onMounted } from 'vue'
import { Menu as Setting } from '@element-plus/icons-vue'
//搜索框
import {  Search } from '@element-plus/icons-vue'

const input2 = ref('')

//搜索框end

// 使用 ref 创建响应式数据
// 创建一个响应式引用来存储从 sessionStorage 中检索到的对象
const studentData = ref(null);
 
// 在组件挂载时存储对象到 sessionStorage
onMounted(() => {
  const storedObjectString = sessionStorage.getItem('studentData');
  if (storedObjectString) {
    studentData.value = JSON.parse(storedObjectString);
  }
});

const item = [
    
    {
    cno: '1',
    cname: 'java',
    credit: '2.5',
    },
    
    {
    cno: '2',
    cname: 'c++',
    credit: '2.5',
    }
]
/* 列表长度*/ 

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