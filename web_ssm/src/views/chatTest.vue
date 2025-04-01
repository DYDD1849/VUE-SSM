<template>
    <div>
      <div
        :class="
          message.sender === Medata.account ? 'chat-message-me' : 'chat-message-other'
        "
        :style="{
          'padding-bottom': messages.length - 1 === index ? '2rem' : 'none',
        }"
        v-for="(message, index) in messages"
        :key="index"
      >
        <!--            消息头像-->
        <!--          消息-->
        <div
          :class="
            message.sender === Medata.account
              ? 'message-me-asWhole-right'
              : 'message-other-asWhole-right'
          "
        >
          <!--            消息上面-->
          <div
            :class="
              message.sender === Medata.account
                ? 'message-me-asWhole-top'
                : 'message-other-asWhole-top'
            "
          >
            {{ (message.sender==Medata.account)?Medata.name:storeReName}}
          </div>
          <!--          消息内容-->
          <div :class="message.sender === Medata.account ? 'message-me' : 'message-other'">
            {{ message.msg }}
          </div>
        </div>
      </div>
      <br />
      <el-affix class="affixcolor" :offset="50" position="bottom">
        <div class="mt-4">
            <el-input
              v-model="textareaMsg"
              size="large"
              style="max-width: 600px"
              placeholder="Please input"
              class="input-with-select"
            >
              <template #prepend>
                <el-button @click="goback">
                    返回
                </el-button>
              </template>
              <template #append>
                <el-button @click="send">
                    发送
                </el-button>
              </template>
            </el-input>
          </div>
      </el-affix>


    </div>
  </template>
  <script>
  import { useRouter,useRoute } from 'vue-router';
  import { ref,watch} from 'vue';
  import { MeSendMessage,LoadMessage } from '@/api/main/chatfun/chatac.js'
  export default {
    setup() {
    const router = useRouter();
    const textareaMsg = ref("");
    const Medata=ref((JSON.parse(sessionStorage.getItem('studentData'))!=null)?JSON.parse(sessionStorage.getItem('studentData')):JSON.parse(sessionStorage.getItem('teacherData')))
    const role=ref(JSON.parse(sessionStorage.getItem('studentData'))!=null?1:2)
    var route = useRoute(); 
    var storeReceiver = route.params.id;
    var storeReName = route.params.name;
    var messages= ref([])

    //
    // 定义一个函数，当 storeReceiver 变化时调用
    const handleStoreReceiverChange = (newReceiver) => {
      console.log('Store receiver changed to:', newReceiver);
      // 在这里添加你想要执行的逻辑
      var message={sender:Medata.value.account,receiver:newReceiver}
      const res = LoadMessage(message)
      messages.value=res
      console.log("ee",messages)
      window.location.reload();
    };
        // 使用 watch 监视 route 对象的变化
        watch(
      () => route,
      (newRoute) => {
        // 更新 storeReceiver 和 storeReName
        storeReceiver = newRoute.params.id;
        storeReName = newRoute.params.name;
        // 调用处理函数
        handleStoreReceiverChange(storeReceiver);
      },
      { deep: true } // 需要深度监视 route 对象的变化
    );

    const loadMessage = async () => {
      var message={sender:Medata.value.account,receiver:storeReceiver}
      const res = await LoadMessage(message)
      messages.value=res.data
      console.log("加载信息",messages.value)
    }
    
    loadMessage()
    const goback =  () => {
    if (role.value==1)
    router.push("/StudentMain");
    else
    router.push("/TeacherMain");
     // 返回
    };

    const send = () => {
      console.log("m",textareaMsg.value)
      storeReceiver = route.params.id;
      storeReName = route.params.name;
      console.log("sss",storeReceiver)
      var Message = { sender:Medata.value.account,receiver:storeReceiver,msg:textareaMsg.value}
      const res = MeSendMessage(Message)
      console.log("我发的信息",res)
      messages.value.push(Message);
    }
 
    return {
      Medata,
      role,
      messages,
      textareaMsg,
      storeReName,
      goback,
      send
      // 如果需要，可以在这里返回其他响应式状态或函数
    };
  },
    
  };
  </script>
  <style>
  .chat-message-other {
    /*background-color: red;*/
    display: flex;
    padding-left: 1rem;
    padding-top: 1rem;
  }
  
  .chat-message-me {
    /*background-color: red;*/
    display: flex;
    padding-right: 1rem;
    padding-top: 1rem;
    flex-direction: row-reverse; /* 将子div的顺序反转 */
  }
  
  .message-me-asWhole-headPortrait {
    padding: 3px;
  }
  
  .message-other-asWhole-headPortrait {
    padding: 3px;
  }
  
  .message-me-asWhole-right {
    display: flex;
    flex-direction: column; /* 设置子元素垂直排列 */
    margin-left: 0.1rem;
  }
  
  .message-other-asWhole-right {
    display: flex;
    flex-direction: column; /* 设置子元素垂直排列 */
    margin-left: 0.1rem;
  }
  
  .message-me-asWhole-top {
    padding: 3px;
    /* font-size: 12px; */
    font-family: 微软雅黑;
    padding: 3px;
    color: rgba(134, 144, 156, 1);
    text-align: right;
  }
  
  .message-other-asWhole-top {
    padding: 3px;
    /* font-size: 12px; */
    font-family: 微软雅黑;
    padding: 3px;
    color: rgba(134, 144, 156, 1);
  }
  
  .message-me {
    background-color: rgba(242, 243, 245, 1);
    max-width: 280px;
    word-wrap: break-word; /* 处理英文单词换行 */
    word-break: break-all; /* 处理中文换行 */
    display: inline-block; /*将div元素转换为行内块元素*/
    width: auto; /* 宽度根据文本宽度自动调正*/
    padding: 6px 12px;
    border-radius: 4px;
  }
  
  .message-other {
    background-color: rgba(242, 243, 245, 1);
    max-width: 280px;
    word-wrap: break-word; /* 处理英文单词换行 */
    word-break: break-all; /* 处理中文换行 */
    display: inline-block; /*将div元素转换为行内块元素*/
    width: auto; /* 宽度根据文本宽度自动调正*/
    padding: 6px 12px;
    border-radius: 4px;
  }
  
  .examineeFace_logo_style {
    width: 30px;
  }
  .affixcolor{
    background-color: rgb(243.9, 244.2, 244.8);
  }
  </style>
  