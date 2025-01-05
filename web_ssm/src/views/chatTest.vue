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
        <div
          :class="
            message.sender === 'me'
              ? 'message-me-asWhole-headPortrait'
              : 'message-other-asWhole-headPortrait'
          "
        >
          <img src="~@/assets/p1.jpg" class="examineeFace_logo_style" />
        </div>
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
            考生
          </div>
          <!--          消息内容-->
          <div :class="message.sender === 'me' ? 'message-me' : 'message-other'">
            {{ message.content }}
          </div>
        </div>
      </div>
      <br />
      <div class="chat-container">
        <textarea></textarea>
      </div>
    </div>
  </template>
  <script>
  export default {
    data() {
      return {
        messages: [
          { sender: "me", content: "你好！" },
          { sender: "other", content: "你好啊！" },
          { sender: "other", content: "请问有什么我可以帮助你的吗？" },
          { sender: "me", content: "我正在寻找一家好的餐厅。" },
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
        ],
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
  /* ... 其他样式 ... */
  
  textarea {
    position: fixed; /* 将textarea固定在视口 */
    bottom: 10px; /* 距离视口底部10px */
    right: 10px; /* 可选：距离视口右侧10px，根据布局需要调整 */
    width: calc(100% - 40px); /* 可选：宽度为视口宽度减去左右各20px的间距 */
    /* 注意：由于使用了fixed定位，rows和cols属性可能不再准确控制尺寸 */
    /* 您可能需要使用height和width属性来更精确地控制尺寸 */
    /* 例如：height: 150px; width: 300px; （根据实际需求调整） */
    /* 但请注意，固定尺寸可能会在不同屏幕尺寸上表现不佳 */
    /* 因此，使用百分比或视口单位（如vw, vh）可能更为灵活 */
  }
  
  /* 如果需要为textarea上方的聊天内容留出空间，可以添加一个底部填充 */
  .chat-container {
    padding-bottom: 170px; /* 根据textarea的高度和底部间距调整 */
  }
  
  /* ... 其他样式 ... */
  </style>
  