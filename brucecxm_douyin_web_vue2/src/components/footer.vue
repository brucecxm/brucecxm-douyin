<template>
    <div class="footer">
        <div class="nav home" :class="{ active: selected === 'home' }" @click="select('home')">
            首页
        </div>
        <div class="nav shop" :class="{ active: selected === 'shop' }" @click="select('shop')">
            商城
        </div>
        <div class="nav add" :class="{ active: selected === 'add' }" @click="select('add')">
            ＋
        </div>
        <div class="nav message" :class="{ active: selected === 'message' }" @click="select('message')">
            消息
        </div>
        <div class="nav me" :class="{ active: selected === 'me' }" @click="select('me')">
            我
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            selected: '', // 当前选中的选项
        };
    },
    methods: {
        select(option) {
            this.selected = option;
            this.$emit('selection-changed', option); // 向父组件传递数据
        }
    }
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
    color: rgba(255, 255, 255, 0.9);
    margin: 0.5rem;
    cursor: pointer;
    /* 添加鼠标光标效果 */
    transition: color 0.3s ease;
    /* 平滑过渡效果 */
}

.nav.active {
    color: #f5f5f5;
    /* 选中时的颜色 */
}
</style>
