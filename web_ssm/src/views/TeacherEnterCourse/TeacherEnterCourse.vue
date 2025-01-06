<template>
    <el-container class="layout-container-demo" style="height: 500px">
        <el-header style="text-align: right; font-size: 12px">
            <div class="searchbar">
                <span>搜索学生</span>
                <el-input
                v-model="input0"
                style="width: 240px"
                placeholder="搜索学生"
                :prefix-icon="Search"
                />
                <button @click="goToTeacherCourse">返回</button>
                <button @click="handleAdd">添加</button>
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
            <span>{{ teacherData ? teacherData.name : 'Default Name' }}</span>
          </div>
        </el-header>
        <el-main>
          <el-scrollbar>
            <el-table :data="items">
              <el-table-column prop="sno" label="学号" width="120" />
              <el-table-column prop="sscore" label="成绩" width="120"/>
              <el-table-column label="学生名" width="120">
              <template #default="scope">
              <el-link href="#" @click="handleManage(scope.row)">{{ scope.row.name }}</el-link>
            </template>
            </el-table-column>
              <el-table-column width="120">
              <template #default="scope">
                <el-link href="#" @click="handleAlter(scope.row)">修改</el-link>
              </template>
              </el-table-column>
              <el-table-column width="120">
              <template #default="scope">
                <el-link href="#" @click="handleDel(scope.row)">删除</el-link>
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
                <span>输入新成绩</span>
                <el-input
                v-model="input1"
                style="width: 240px"
                placeholder="输入成绩"
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

  <el-dialog
    v-model="dialogVisibleDel"
    title="Tips"
    width="500"
    :before-close="handleClose"
  >
  <span>确认要删除吗</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button type="primary" @click="del">
          删除
        </el-button>
        <el-button @click="dialogVisibleDel = false">取消</el-button>
      </div>
    </template>
  </el-dialog>

  <el-dialog
    v-model="dialogVisibleAdd"
    title="Tips"
    width="500"
    :before-close="handleClose"
  >
  <div class="searchbar">
                <span>输入新成绩</span>
                <el-input
                v-model="input2"
                style="width: 200px"
                placeholder="输入学号"
                :prefix-icon="Search"
                />
                <el-input
                v-model="input3"
                style="width: 200px"
                placeholder="输入成绩"
                :prefix-icon="Search"
                />
  </div>
    <template #footer>
      <div class="dialog-footer">
        <el-button type="primary" @click="add">
          修改
        </el-button>
        <el-button @click="dialogVisibleAdd = false">取消</el-button>
      </div>
    </template>
  </el-dialog>
</template>
<script setup>
  import { ref} from 'vue';
  import { teacherEnterCourse } from '@/api/main/teacherMain.js';
  import { useRouter,useRoute } from 'vue-router';
  import {TeacherAltScore,TeacherDelScore,TeacherAddScore} from '@/api/main/teacherDoSC/scoreUpdate.js';
//教师信息传递
  const teacherData = ref(null);
//存储所有成绩信息
  const items = ref([]); 
//修改 删除框显示
  const storeSno =ref(null);
  const storeCno =ref(null);
  const dialogVisibleAlter = ref(false)
  const dialogVisibleDel = ref(false)
  const dialogVisibleAdd = ref(false)

// 跳转聊天函数
const handleManage = (row) => {
  console.log('Managing tea:', row.account);

  
   router.push({name: 'GoChat',params:{id:row.account}});
};

// 修改 删除点击事件处理函数
const handleAlter = (row) => {
  dialogVisibleAlter.value=true;
  storeSno.value=row.sno;
  console.log('AstoreSno', storeSno);
  //router.push({name: 'routeName',params:{ cno:row.cno}});
};

const handleDel = (row) => {
  dialogVisibleDel.value=true;
  storeSno.value=row.sno;
  console.log('DstoreSno', storeSno);
  //router.push({name: 'routeName',params:{ cno:row.cno}});
};

const handleAdd = () => {
  dialogVisibleAdd.value=true;
  //router.push({name: 'routeName',params:{ cno:row.cno}});
};
//修改内容处理
const input1 = ref();
const input2 = ref();
const input3 = ref();
const modify = async()=>{
  const score ={sno:storeSno.value,cno:storeCno.value,sscore:input1.value};
  const res = await TeacherAltScore(score);
  console.log(res);
  window.location.reload();
}
//删除内容处理
const del = async()=>{
  const score ={sno:storeSno.value,cno:storeCno.value,sscore:input1.value};
  const res = await TeacherDelScore(score);
  console.log(res);
  window.location.reload();
}
//添加内容处理
const add = async()=>{
  const score ={sno:input2.value,cno:storeCno.value,sscore:input3.value};
  const res = await TeacherAddScore(score);
  console.log(res);
  window.location.reload();
}

// 从 sessionStorage 获取管理员数据，并调用 API
const loadTeacherData = async () => {
  const storedObjectString = sessionStorage.getItem('teacherData');
  if (storedObjectString) {
    teacherData.value = JSON.parse(storedObjectString);
    
    // 如果 teacherData 有值，则调用 teacherEnterCourse API
    if (teacherData.value) {
      try {
        
        const route = useRoute(); // 使用 useRoute 获取当前路由
        storeCno.value=route.params.cno;
        const course ={cno:storeCno.value};
        console.log(storeCno.value)
        const res = await teacherEnterCourse(course);
        if (res && res.data) {
          items.value = res.data; 
          console.log(items);
          
        } else {
          console.warn('API 响应不包含 data 属性');
        }
      } catch (error) {
        console.error('调用 teacherEnterCourse 时出错:', error);
      }
    }
  } else {
    console.warn('sessionStorage 中没有存储 teacherData');
  }
};
// 立即调用这个函数
loadTeacherData(); // 立即加载数据

//路由跳转返回
const router = useRouter();
const goToTeacherCourse = () => {
  router.push("/TeacherMain");
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