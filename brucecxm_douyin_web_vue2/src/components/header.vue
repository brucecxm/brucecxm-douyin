<template>
    <div class="header">
        <div class="menu"></div>
        <div class="nav" ref="nav">
            <p>经验</p>
            <p>经验</p>
            <p>经验</p>
            <p>经验</p>
            <p>经验</p>
        </div>
        <div class="search"></div>
    </div>
</template>

<script>
export default {
    mounted() {
        const nav = this.$refs.nav;
        let isDragging = false;
        let startX;
        let scrollLeft;

        nav.addEventListener('mousedown', (e) => {
            isDragging = true;
            startX = e.pageX - nav.offsetLeft;
            scrollLeft = nav.scrollLeft;
        });

        nav.addEventListener('mouseleave', () => {
            isDragging = false;
        });

        nav.addEventListener('mouseup', () => {
            isDragging = false;
        });

        nav.addEventListener('mousemove', (e) => {
            if (!isDragging) return;
            e.preventDefault();
            const x = e.pageX - nav.offsetLeft;
            const scroll = (x - startX) * 2; // Adjust scroll speed with factor (2 in this case)
            nav.scrollLeft = scrollLeft - scroll;
        });
    },
};
</script>

<style scoped>
.header {
    width: 100%;
    height: 10vh;
    display: flex;
    flex-direction: row;
}

.menu {
    width: 10vw;
    height: 10vw;
    background-image: url(../assets/home/菜单.png);
    background-size: 10vw 10vw;
    background-repeat: no-repeat;
}

.nav {
    width: 80vw;
    height: 100%;
    display: flex;
    flex-direction: row;
    overflow: hidden;
    align-items: center;
    overflow-x: auto;
    cursor: grab;
}

/* 隐藏滚动条但保留滚动功能 */
.nav::-webkit-scrollbar {
    display: none;
}

p {
    font-size: 5vw;
    margin: 5vw;
    flex-shrink: 0;
    user-select: none;
}

.search {
    width: 10vw;
    height: 10vw;
    background-image: url(../assets/home/放大镜.png);
    background-size: 10vw 10vw;
    background-repeat: no-repeat;
}
</style>
