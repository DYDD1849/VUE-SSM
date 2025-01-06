<template>
    <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <div class="toolbar">
            <div class="mt-4" style="margin-right: 10%;">
                  <el-input
                    v-model="input0"
                    style="max-width: 240px"
                    placeholder="搜索教师"
                    class="input-with-select"
                  >
                  <template #append>
                  <el-button :icon="Search" @click="SearchStudent">
                    搜索
                  </el-button>
                  </template>
                  </el-input>
            </div>
          </div>
        </el-header>
        <el-main>
          <el-scrollbar>
            <el-table :data="items">
              <el-table-column prop="tno" label="教工号" width="120" />
              <el-table-column prop="name" label="姓名" width="120" />
              <el-table-column prop="college" label="院系" width="120"/>
              <el-table-column prop="sex" label="性别" width="120"/>
              <el-table-column prop="title" label="职衔" width="120"/>
              <el-table-column prop="account" label="账号" width="120"/>
              <el-table-column width="120">
              <template #default="scope">
                <el-link href="#" @click="handleAlter(scope.row)">修改</el-link>
              </template>
              </el-table-column>
            </el-table>
          </el-scrollbar>
        </el-main>
    </el-container>
  <el-dialog
    v-model="dialogVisibleAlter"
    title="Tips"
    width="500"
    :before-close="handleClose"
  >
  <div class="searchbar">
                <span>输入新姓名</span>
                <el-input
                v-model="input1"
                style="width: 240px"
                placeholder="输入更改后的姓名"
                :prefix-icon="Search"
                />
  </div>
  <div class="searchbar">
                <span>输入新院系</span>
                <el-input
                v-model="input2"
                style="width: 240px"
                placeholder="输入更改后的院系"
                :prefix-icon="Search"
                />
  </div>
  <div class="searchbar">
                <span>输入新性别</span>
                <el-input
                v-model="input3"
                style="width: 240px"
                placeholder="输入更改后的性别"
                :prefix-icon="Search"
                />
  </div>
  <div class="searchbar">
                <span>输入新职衔</span>
                <el-input
                v-model="input4"
                style="width: 240px"
                placeholder="输入更改后的职衔"
                :prefix-icon="Search"
                />
  </div>
    <template #footer>
      <div class="dialog-footer">
        <el-button type="primary" @click="modify">
          修改
        </el-button>
        <el-button @click="dialogVisibleAlter = false">取消</el-button>
      </div>
    </template>
  </el-dialog>
  </template>
  <script setup>
  import { ref } from 'vue';
  import { teacherTable,UpdateTeacher } from '@/api/main/manager/teacherTable.js';
  
//管理员信息传递
  const managerData = ref(null);
//存储所有老师信息
  const items = ref([]); 

//修改老师的信息储存
  const teacher =ref({});
  const dialogVisibleAlter = ref(false)

  const input1 = ref();
  const input2 = ref();
  const input3 = ref();
  const input4 = ref();
// 修改 点击事件处理函数
const handleAlter = (row) => {
  dialogVisibleAlter.value=true;
  teacher.value.tno=row.tno;
  teacher.value.account=row.account;

  input1.value=row.name;
  input2.value=row.college;
  input3.value=row.sex;
  input4.value=row.title;
  
  console.log('AstoreSno', teacher.value);
  //router.push({name: 'routeName',params:{ cno:row.cno}});
};

const modify = async()=>{
  teacher.value.name=input1.value;
  teacher.value.college=input2.value;
  teacher.value.sex=input3.value;
  teacher.value.title=input4.value;
  

  console.log('AfSno', teacher.value);

  const res = await UpdateTeacher(teacher.value);
  console.log(res);
  window.location.reload();
  
}

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
  background-color: rgba(#FFFFFF);
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
    display: inline-flex;
    align-items: center;
    justify-content: center;
    height: 100%;
  }
  </style>