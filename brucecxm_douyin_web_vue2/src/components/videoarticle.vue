<template>
    <div class="videoarticle">
        <div class="username">{{ username }}</div>
        <div class="article">{{ article }}</div>
    </div>
</template>

<script>

export default {
    data() {
        return {
            article: "感谢穿越火线感谢穿越火线感谢穿越火线",
            username: "你好"
        };
    },

};
</script>

<style scoped>
.videoarticle {
    width: 75vw;
    max-height: 20vh;
    color: white;
}

.article {
    font-size: 0.5rem;
}

.username {
    font-size: 0.5rem;
}
</style>
