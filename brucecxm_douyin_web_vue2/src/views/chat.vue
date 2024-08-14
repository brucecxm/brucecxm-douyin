<template>
    <div class="chat-container">
        <!-- 消息显示区域 -->
        <div class="chat-window">
            <div v-for="(message, index) in sortedMessages" :key="index"
                :class="['chat-bubble-container', message.isMine ? 'mine' : 'theirs']">
                <div class="chat-bubble">
                    <div class="message-content">
                        <div v-if="message.type === 'text'">{{ message.content }}</div>
                        <img v-if="message.type === 'image'" :src="message.content" alt="Image" class="chat-image" />
                        <video v-if="message.type === 'video'" :src="message.content" controls class="chat-video"></video>
                    </div>
                    <div class="timestamp">{{ formatTime(message.timestamp) }}</div>
                </div>
            </div>
        </div>

        <!-- 消息输入区域 -->
        <div class="chat-input">
            <input v-model="newMessage" type="text" placeholder="Type a message..." @keyup.enter="sendMessage" />
            <button @click="sendMessage">Send</button>

            <!-- 上传文件按钮 -->
            <input type="file" @change="handleFileUpload" ref="fileInput" hidden />
            <button @click="triggerFileInput">📎</button>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            messages: [
                { content: "Hello!", isMine: false, type: "text", timestamp: 1691568300000 },
                { content: "Hi, how are you?", isMine: true, type: "text", timestamp: 1691571900000 },
                { content: "I'm good, thanks!", isMine: false, type: "text", timestamp: 1691575500000 },
            ],
            newMessage: "", // 用户输入的新消息
        };
    },
    computed: {
        sortedMessages() {
            return this.messages.sort((a, b) => a.timestamp - b.timestamp);
        },
    },
    methods: {
        sendMessage() {
            if (this.newMessage.trim() !== "") {
                this.messages.push({
                    content: this.newMessage,
                    isMine: true,
                    type: "text",
                    timestamp: Date.now(),
                });
                this.newMessage = ""; // 清空输入框
            }
        },
        triggerFileInput() {
            this.$refs.fileInput.click();
        },
        handleFileUpload(event) {
            const file = event.target.files[0];
            if (file) {
                const fileType = file.type.split("/")[0];
                const reader = new FileReader();

                reader.onload = () => {
                    const messageType = fileType === "image" ? "image" : fileType === "video" ? "video" : "text";
                    this.messages.push({
                        content: reader.result,
                        isMine: true,
                        type: messageType,
                        timestamp: Date.now(),
                    });
                };

                reader.readAsDataURL(file); // 读取文件数据
            }
        },
        formatTime(timestamp) {
            const date = new Date(timestamp);
            return `${date.getHours()}:${String(date.getMinutes()).padStart(2, "0")}`;
        },
    },
};
</script>

<style scoped>
.chat-container {
    display: flex;
    flex-direction: column;
    height: 80vh;
    max-width: 600px;
    margin: 0 auto;
    border: 1px solid #ddd;
    border-radius: 10px;
}

.chat-window {
    flex-grow: 1;
    padding: 10px;
    overflow-y: auto;
    background-color: #f5f5f5;
    margin-bottom: 20px;
}

.chat-bubble-container {
    display: flex;
    margin-bottom: 20px;
}

.mine {
    justify-content: flex-end;
}

.theirs {
    justify-content: flex-start;
}

.chat-bubble {
    max-width: 70%;
    padding: 10px;
    border-radius: 10px;
    background-color: #e0e0e0;
    color: black;
    position: relative;
    word-wrap: break-word;
}

.mine .chat-bubble {
    background-color: #4caf50;
    color: white;
}

.message-content {
    margin-bottom: 5px;
}

.timestamp {
    font-size: 0.8em;
    color: #999;
    position: absolute;
    bottom: -18px;
    left: 10px;
}

.mine .timestamp {
    right: 10px;
    left: auto;
}

.chat-input {
    display: flex;
    padding: 10px;
    border-top: 1px solid #ddd;
    background-color: white;
}

.chat-input input[type="text"] {
    flex-grow: 1;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 20px;
    margin-right: 10px;
}

.chat-input button {
    padding: 10px 15px;
    border: none;
    border-radius: 50%;
    background-color: #4caf50;
    color: white;
    cursor: pointer;
}

.chat-image {
    max-width: 100%;
    border-radius: 10px;
}

.chat-video {
    max-width: 100%;
    border-radius: 10px;
}
</style>
