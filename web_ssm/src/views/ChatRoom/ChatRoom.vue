<template>
    <div>
        <el-container class="container">
            <el-aside class="aside" width="200px">
                <el-menu>
                <el-menu-item index="4" class="contactb1" :key="item.account" v-for="item in contact" @click="gotoChat">
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
export default{
    name:"ChatRoom",
    data(){
        return{
            contact:[
                {"name":"abc","account":123},
                {"name":"afadf","account":122},
                {"name":"hello","account":123323}
            ],
            id:1
        }
    },
    methods:{
        gotoChat:function(){
            this.$router.push("GoChat",{id:this.id})
        }
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
    height: 600px;
}
</style>