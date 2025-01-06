<template>
    <el-container class="layout-container-demo" style="height: 100%">
        <el-header style="text-align: right; font-size: 12px">
          <div class="toolbar">
            <div class="mb-4" style="margin-right: 50px;">
              <el-button type="primary" plain @click="gotoChat">邮箱</el-button>
            </div>
            <div class="mt-4" style="margin-right: 10%;">
              <el-input
                    v-model="input0"
                    style="max-width: 320px"
                    placeholder="搜索你的课程"
                    class="input-with-select"
                  >
                  <template #append>
                  <el-button :icon="Search" @click="SearchCourse">
                    搜索
                  </el-button>
                </template>
              </el-input>
            </div>
            <div class="mb-4">
              <el-button type="primary" plain @click="quitAction">退出</el-button>
            </div>
            <el-text class="mx-1" type="primary" size="large" style="margin-right: 50px;">
              {{ studentData ? studentData.name : 'Default Name' }}
            </el-text>
          </div>
        </el-header>
        <el-main>
          <el-scrollbar>
            <el-table :data="items">
              <el-table-column prop="course.cname" label="课程名" width="120" />
              <el-table-column prop="course.cno" label="课程号" width="120" />
              <el-table-column prop="course.credit" label="学分" width="120"/>
              <el-table-column prop="course.semester" label="学期" width="120"/>
              <el-table-column prop="course.ctime" label="学时" width="120"/>
              <el-table-column prop="sScore" label="成绩" width="120"/>
              <el-table-column label="教师" width="120">
              <template #default="scope">
              <el-link href="#" @click="handleManage(scope.row)">{{ scope.row.teacher.name }}</el-link>
            </template>
            </el-table-column>
            </el-table>
          </el-scrollbar>
        </el-main>
    </el-container>
</template>
<script setup>
import { ref } from 'vue';
import { studentMain,searchStudentScore } from '@/api/main/studentMain.js';
import { useRouter } from 'vue-router';

const studentData = ref(null);
const items = ref([]); // 用于存储课程数据的响应式引用
const input0 =ref();

const SearchCourse =async()=>{
  console.log("input",input0.value)
  const student={name:input0.value,sno:studentData.value.sno}
  const res = await searchStudentScore(student);
  items.value=res.data;
  console.log("name",res);
}
//路由跳转
//退出按钮
const router = useRouter();
const quitAction = async()=>{
  sessionStorage.clear();
  router.push("/");
}
//邮箱
const gotoChat = async()=> {
  router.push("/GoChatRoom");
}
// 跳转聊天函数
const handleManage = (row) => {
  console.log('Managing tea:', row.teacher.account);
  // 这里可以添加跳转到管理页面的逻辑，例如使用 vue-router 导航到一个管理详情页面
  // router.push({ name: 'courseManage', params: { courseId: row.cno } });
  
   router.push({name: 'GoChat',params:{id:row.teacher.account}});
};

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