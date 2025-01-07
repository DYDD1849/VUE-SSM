<template>
    <div>
        <el-container class="container">
            <el-aside class="aside" width="200px">
                <el-menu>
                <el-menu-item index="4" class="contactb1" :key="item.account" v-for="item in contact" @click="gotoChat(item)">
                    <template #title >{{ item.name }}</template>
                  </el-menu-item>   
                </el-menu>
            </el-aside>
                <el-main class="main">
                    <router-view/>
                </el-main>
        </el-container>
    </div>
</template>
<script>
import {ref} from 'vue'
// import {MeGetMessage} from '@/api/main/chatfun/chatac.js'
export default{
    name:"ChatRoom",
    data(){
        return{
            // 这个数据存储sender发送者的名字，账号
            contact:[
                {"name":"abc","account":123},
                {"name":"afadf","account":122},
                {"name":"hello","account":123323}
            ],
            id:1
        }
    },
    created() {
        this.Getcontant();
    },
    methods:{
        // 点击之后跳转main页面，将上面数据的account传输到聊天页面。聊天页面通过sender和receiver来查询显示所有信息
        gotoChat:function(item){
            const role=ref(JSON.parse(sessionStorage.getItem('studentData'))!=null?1:2)
            this.id=item.account
            console.log("ss",this.id)
            if (role.value==1)
            this.$router.push({name:"StudentToChat",params:{id:this.id}})
            else
            this.$router.push({name:"TeacherToChat",params:{id:this.id}})
        },
        Getcontant:function(){
            const Medata=ref((JSON.parse(sessionStorage.getItem('studentData'))!=null)?JSON.parse(sessionStorage.getItem('studentData')):JSON.parse(sessionStorage.getItem('teacherData')))
            const account=Medata.value.account
            console.log("accont",account)
            // const res = MeGetMessage(account)
            // console.log(res)
        },
    }
    
}

</script>
<style>
.aside{
    display: flex;
    background-color: rgb(177.3, 179.4, 183.6);
    border-radius: 4px;
    flex-direction:column
}
.main{
    background-color:rgb(243.9, 244.2, 244.8);
    border-radius: 4px
}
.contactb1{
    background-color: #EBEEF5;
}
.container{
    height: 650px;
}
</style>