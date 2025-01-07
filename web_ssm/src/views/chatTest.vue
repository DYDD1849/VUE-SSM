<template>
    <div>
      <div
        :class="
          message.sender === 'me' ? 'chat-message-me' : 'chat-message-other'
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
            message.sender === 'me'
              ? 'message-me-asWhole-right'
              : 'message-other-asWhole-right'
          "
        >
          <!--            消息上面-->
          <div
            :class="
              message.sender === 'me'
                ? 'message-me-asWhole-top'
                : 'message-other-asWhole-top'
            "
          >
            {{ (message.sender==Medata.account)?Medata.name:"other"}}
          </div>
          <!--          消息内容-->
          <div :class="message.sender === 'me' ? 'message-me' : 'message-other'">
            {{ message.content }}
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
  import { ref} from 'vue';
  import { MeSendMessage } from '@/api/main/chatfun/chatac.js'
  export default {
    setup() {
    const router = useRouter();
    const textareaMsg = ref("");
    const Medata=ref((JSON.parse(sessionStorage.getItem('studentData'))!=null)?JSON.parse(sessionStorage.getItem('studentData')):JSON.parse(sessionStorage.getItem('teacherData')))
    const role=ref(JSON.parse(sessionStorage.getItem('studentData'))!=null?1:2)
    var route = useRoute(); 
    var storeReceiver = route.params.id;
    const messages= ref([
          { sender: "123456", content: "你好！" },
          { sender: "other", content: "你好啊！" },
          { sender: "other", content: "请问有什么我可以帮助你的吗？" },
          { sender: "123456", content: "我正在寻找一家好的餐厅。" },
          { sender: "other", content: "你在哪个城市？" },
          { sender: "me", content: "我在北京。" },
          {
            sender: "other",
            content: "好的，我可以为您推荐一些北京的餐厅。您需要什么类型的餐厅？",
          },
          { sender: "me", content: "我想要吃火锅。" },
          {
            sender: "other",
            content:
              "好的，以下是我为您推荐的北京火锅餐厅列表：[餐厅1，餐厅2，餐厅3]。您需要我帮您预约吗？",
          },
          { sender: "me", content: "不需要，我会自己预约。谢谢您的帮助！" },
          { sender: "other", content: "不客气，祝您用餐愉快！" },
          { sender: "me", content: "再见！" },
          { sender: "other", content: "再见！" },
        ])

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
      console.log("sss",storeReceiver)
      var Message = { sender:Medata.value.account,receiver:storeReceiver,msg:textareaMsg.value}
      const res = MeSendMessage(Message)
      console.log("我发的信息",res)
    }
 
    return {
      Medata,
      role,
      messages,
      textareaMsg,
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
  