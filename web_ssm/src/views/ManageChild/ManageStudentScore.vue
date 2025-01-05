<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-header style="text-align: right; font-size: 12px">
            <div class="searchbar">
                <span>搜索学生</span>
                <el-input
                v-model="input2"
                style="width: 240px"
                placeholder="搜索学生"
                :prefix-icon="Search"
                />
                <button @click="goToTeacherCourse">返回</button>
                <button @click="handleAdd">添加</button>
                {{ storeCno }}
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
              <el-table-column prop="sno" label="学号" width="120" />
              <el-table-column prop="cno" label="课程号" width="120" />
              <el-table-column prop="sscore" label="成绩" width="120"/>
            </el-table>
          </el-scrollbar>
        </el-main>
    </el-container>
</template>
<script setup>
  import { ref } from 'vue';
  import { useRouter,useRoute } from 'vue-router';
  import { StudentCourseTable } from '@/api/main/manager/StudentCourseTable.js';

  const storeCno =ref(null);
//管理员信息传递
  const managerData = ref(null);
//存储所有成绩信息
  const items = ref([]); 
  
// 从 sessionStorage 获取管理员数据，并调用 API
const loadManageData = async () => {
  const storedObjectString = sessionStorage.getItem('managerData');
  if (storedObjectString) {
    managerData.value = JSON.parse(storedObjectString);
    
    // 如果 managerData 有值，则调用 StudentCourseTable API
    if (managerData.value) {
      try {
        const res = await StudentCourseTable();
        if (res && res.data) {
          const route = useRoute(); // 使用 useRoute 获取当前路由
          storeCno.value=route.params.cno;
          items.value = res.data; 
          console.log(items);
          
        } else {
          console.warn('API 响应不包含 data 属性');
        }
      } catch (error) {
        console.error('调用 StudentCourseTable 时出错:', error);
      }
    }
  } else {
    console.warn('sessionStorage 中没有存储 managerData');
  }
};

// 立即调用这个函数
loadManageData(); // 立即加载数据

//路由跳转返回
const router = useRouter();
const goToTeacherCourse = () => {
  router.push("/ManageSCroot");
};

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