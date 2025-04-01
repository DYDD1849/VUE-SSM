<template>
    <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <div class="toolbar">
            <div class="mt-4" style="margin-right: 10%;">
                  <el-input
                    v-model="input0"
                    style="max-width: 240px"
                    placeholder="搜索学生"
                    class="input-with-select"
                  >
                  <template #append>
                    <el-button @click="SearchStudent">搜索</el-button>
                  </template>
                  </el-input>
            </div>
          </div>
        </el-header>
        <el-main>
          <el-scrollbar>
            <el-table :data="items">
              <el-table-column prop="sno" label="学号" width="120" />
              <el-table-column prop="name" label="姓名" width="120" />
              <el-table-column prop="account" label="账号" width="120"/>
              <el-table-column prop="sex" label="性别" width="120"/>
              <el-table-column prop="college" label="学院" width="120"/>
              <el-table-column prop="major" label="专业" width="120"/>
              <el-table-column prop="phone" label="手机" width="120"/>
              <el-table-column prop="address" label="地址" width="120"/>
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
                <span>输入新性别</span>
                <el-input
                v-model="input2"
                style="width: 240px"
                placeholder="输入更改后的性别"
                :prefix-icon="Search"
                />
  </div>
  <div class="searchbar">
                <span>输入新学院</span>
                <el-input
                v-model="input3"
                style="width: 240px"
                placeholder="输入更改后的学院"
                :prefix-icon="Search"
                />
  </div>
  <div class="searchbar">
                <span>输入新专业</span>
                <el-input
                v-model="input4"
                style="width: 240px"
                placeholder="输入更改后的专业"
                :prefix-icon="Search"
                />
  </div>
  <div class="searchbar">
                <span>输入新手机</span>
                <el-input
                v-model="input5"
                style="width: 240px"
                placeholder="输入更改后的手机"
                :prefix-icon="Search"
                />
  </div>
  <div class="searchbar">
                <span>输入新地址</span>
                <el-input
                v-model="input6"
                style="width: 240px"
                placeholder="输入更改后的地址"
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
import { studentTable,UpdateStudent,searchStudent } from '@/api/main/manager/studentTable.js';
 
// const input2 = ref('');

//管理员信息传递
const managerData = ref(null);

//存储所有学生信息
const items = ref([]);
 
//修改学生的信息储存
  const student =ref({});
  const dialogVisibleAlter = ref(false)

  const input0 = ref();
  const input1 = ref();
  const input2 = ref();
  const input3 = ref();
  const input4 = ref();
  const input5 = ref();
  const input6 = ref();

  //搜索功能
  const SearchStudent =async()=>{
  console.log("input",input0.value)
  const student={name:input0.value}
  const res = await searchStudent(student);
  items.value=res.data;
  console.log("name",res);
}  
// 修改 点击事件处理函数
const handleAlter = (row) => {
  dialogVisibleAlter.value=true;
  student.value.sno=row.sno;
  student.value.account=row.account;

  input1.value=row.name;
  input2.value=row.sex;
  input3.value=row.college;
  input4.value=row.major;
  input5.value=row.phone;
  input6.value=row.address;
  
  console.log('AstoreSno', student.value);
  //router.push({name: 'routeName',params:{ cno:row.cno}});
};

const modify = async()=>{
  student.value.name=input1.value;
  student.value.sex=input2.value;
  student.value.college=input3.value;
  student.value.major=input4.value;
  student.value.phone=input5.value;
  student.value.address=input6.value;
  
  console.log('AfSno', student.value);

  const res = await UpdateStudent(student.value);
  console.log(res);
  window.location.reload();
  
}

// 从 sessionStorage 获取管理员数据，并调用 API
const loadManageData = async () => {
  const storedObjectString = sessionStorage.getItem('managerData');
  if (storedObjectString) {
    managerData.value = JSON.parse(storedObjectString);
    
    // 如果 managerData 有值，则调用 studentTable API
    if (managerData.value) {
      try {
        const res = await studentTable();
        if (res && res.data) {
          items.value = res.data; 
          console.log(items);
          // 假设 API 返回的数据中有一个 data 属性包含课程列表
        } else {
          console.warn('API 响应不包含 data 属性');
        }
      } catch (error) {
        console.error('调用 studentTable 时出错:', error);
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