<template>
    <div class="footer">
        <div class="home nav">首页</div>
        <div class="shop nav">商城</div>
        <div class="add nav">＋</div>
        <div class="message nav">消息</div>
        <div class="me nav">我</div>
    </div>
</template>

<script>

export default {
    data() {
        return {

        };
    },

};
</script>

<style scoped>
.footer {
    width: 100%;
    height: 2rem;
    background-color: black;

    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
}

.nav {
    font-size: 0.7rem;
    color: white;

}
</style>
