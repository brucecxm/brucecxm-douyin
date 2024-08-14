<!-- 没有简化的swpi.vue -->

<template>
    <div class="testsw">
        <p>current: {{ currentX }}</p>
        <p>start: {{ startX }}</p>
        <p>isDragging: {{ isDragging }}</p>

        <ul>
            <li @click="goone">1</li>
            <li @click="gotwo">2</li>
            <li @click="gothree">3</li>
        </ul>

        <div class="box" @mousedown="startDrag" @mouseup="stopDrag" @mousemove="drag" @mouseleave="stopDrag">
            <div ref="box1" class="box1 yangshi"></div>
            <div ref="box2" class="box2 yangshi"></div>
            <div ref="box3" class="box3 yangshi"></div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            isDragging: false, // 是否正在拖动
            startX: 0, // 拖动开始时的 X 坐标
            currentX: 0, // 当前 X 坐标
        };
    },

    methods: {
        startDrag(event) {
            event.preventDefault();  // 防止默认拖动行为
            this.isDragging = true;
            this.startX = event.clientX - this.currentX;
            console.log("start");



        },
        stopDrag(event) {
            event.preventDefault();  // 防止默认拖动行为
            this.isDragging = false;
            console.log("stop");
            this.updateBoxPositionBasedOnCurrentX()
        },
        drag(event) {
            if (this.isDragging) {
                console.log("drag");
                let newX = event.clientX - this.startX;

                // 限制坐标范围在 -400px 到 0px 之间
                newX = Math.max(-400, Math.min(newX, 0));

                this.currentX = newX;
                this.updateBoxesPosition();

            }
        },



        updateBoxesPosition() {
            this.$refs.box1.style.left = `${this.currentX}px`;
            this.$refs.box2.style.left = `${this.currentX + 200}px`;
            this.$refs.box3.style.left = `${this.currentX + 400}px`;
        },
        goone() {
            console.log('one');
            this.updateBoxPosition(0, 200, 400);
        },
        gotwo() {
            console.log('two');
            this.updateBoxPosition(-200, 0, 200);
        },
        gothree() {
            console.log('three');
            this.updateBoxPosition(-400, -200, 0);
        },
        updateBoxPosition(left1, left2, left3) {
            this.$refs.box1.style.left = `${left1}px`;
            this.$refs.box2.style.left = `${left2}px`;
            this.$refs.box3.style.left = `${left3}px`;
        },
        handleLargeMove() {
            console.log('Large move detected');
            // 在这里执行你需要调用的方法
        },
        updateBoxPositionBasedOnCurrentX() {
            if (this.currentX > -100) {
                this.goone();
            } else if (this.currentX > -200) {
                this.gotwo();
            } else if (this.currentX > -300) {
                this.gotwo();
            } else if (this.currentX > -400) {
                this.gothree();
            } else if (this.currentX > -500) {
                this.gothree();
            }
        }

    },
};
</script>

<style scoped>
/* 外部容器样式 */
.box {
    display: flex;
    width: 200px;
    height: 200px;
    background-color: rgba(0, 0, 0, 0.1);
    position: relative;
    overflow: hidden;
}

/* 内部盒子样式 */
.box1,
.box2,
.box3 {
    width: 200px;
    height: 200px;
    position: absolute;
}

/* 第一个盒子的初始位置和颜色 */
.box1 {
    background-color: red;
    left: 0;
}

/* 第二个盒子的初始位置和颜色 */
.box2 {
    background-color: blue;
    left: 200px;
}

/* 第三个盒子的初始位置和颜色 */
.box3 {
    background-color: yellow;
    left: 400px;
}

/* 公共样式，包括过渡效果 */
.yangshi {
    transition: left 0.1s;
}
</style>
