<template>
    <div class="testsw">

        <!-- 显示当前的X位置、起始位置以及是否正在拖动的状态 -->
        <p>current: {{ currentX }}</p>
        <p>start: {{ startX }}</p>
        <p>isDragging: {{ isDragging }}</p>
        <button @click="showcaidanone">show</button>




        <ul ref="ul" class="nav-list">
            <li @click="go(index)" v-for="(box, index) in boxes" :key="index" :class="{ active: activeIndex === index }">
                {{ box.boxtest }}
            </li>
        </ul>





        <div class="sex">
            <caidan :style="caidancss"></caidan>

            <div :style="boxvideocss">


                <!-- 容器div，包含鼠标和触摸事件监听 -->
                <div class="container" @mousedown="startDrag" @mouseup="stopDrag" @mousemove="drag" @mouseleave="stopDrag"
                    @touchstart="startDrag" @touchend="stopDrag" @touchmove="drag"
                    :style="{ width: boxWidth + 'px', height: boxHeight + 'px' }">
                    <!-- 循环渲染每个box，设置样式 -->
                    <div v-for="( box, index ) in  boxes " :key="index" class="box"
                        :style="{ left: box.left + 'px', backgroundColor: box.color, width: boxWidth + 'px', height: boxHeight + 'px' }">
                        <shi-ping v-if="index % 2 === 0"></shi-ping> <!-- 偶数索引使用 ShiPing -->
                        <shi-ping-one v-else></shi-ping-one> <!-- 奇数索引使用 ShiPingOne -->
                    </div>
                </div>


            </div>
        </div>








    </div>
</template>

<script>
import ShiPing from '../components/shiping.vue';
import ShiPingOne from '../components/shipingone.vue';
import caidan from '../components/caidan.vue';
export default {
    data() {
        return {
            isDragging: false, // 是否正在拖动的标志
            startX: 0, // 拖动的起始X位置
            currentX: 0, // 当前的X位置
            boxWidth: 400, // 每个box的宽度
            activeIndex: null, // 当前被点击的li索引
            boxHeight: 800,
            boxes: [] // box的数据，包括颜色和左边距
            ,
            caidanone: "caidanone",
            caidancss: {
                position: 'absolute',
                right: '400px',
                bottom: '0px',
                transition: 'right 0.5s ease' /* 控制位置变化的动画 */
            },
            boxvideocss: {
                width: '400px',
                height: '800px',
                backgroundColor: 'blue',
                transform: 'translateX(0px)',
                overflow: 'hidden',
                transition: 'transform 0.5s ease' /* 控制位置变化的动画 */
            }
        };
    },
    components: {
        ShiPing,
        ShiPingOne,
        caidan

    },

    created() {
        // 初始化 boxes 的数据，包括颜色和左边距
        this.boxes = [
            { color: "red", left: 0, boxtest: "推荐" },
            { color: "blue", left: this.boxWidth, boxtest: "直播" },
            { color: "yellow", left: 2 * this.boxWidth, boxtest: "关注" },
            { color: "pink", left: 3 * this.boxWidth, boxtest: "同城" },
        ];
    },
    methods: {

        startDrag(event) {
            event.preventDefault();
            this.isDragging = true;
            this.startX = this.getEventClientX(event) - this.currentX;
        },
        stopDrag(event) {
            event.preventDefault();
            this.isDragging = false;
            this.updateBoxPositionBasedOnCurrentX();
        },
        drag(event) {
            if (this.isDragging) {
                let newX = this.getEventClientX(event) - this.startX;
                newX = Math.max(-(this.boxWidth * (this.boxes.length - 1)), Math.min(newX, 0));
                this.currentX = newX;
                this.updateBoxesPosition();
                this.updateLiPosition();
            }
        },
        getEventClientX(event) {
            return event.type.startsWith("touch") ? event.touches[0].clientX : event.clientX;
        },
        updateBoxesPosition() {
            this.boxes.forEach((box, index) => {
                box.left = this.currentX + index * this.boxWidth;
            });
        },
        updateBoxPositionBasedOnCurrentX() {
            const nearestIndex = Math.round(Math.abs(this.currentX) / this.boxWidth);
            this.currentX = -nearestIndex * this.boxWidth;
            this.updateBoxesPosition();
            this.updateLiPosition();
        },
        updateLiPosition() {
            const ul = this.$refs.ul;
            const lis = ul.querySelectorAll('li');
            lis.forEach((li, index) => {
                const liWidth = li.offsetWidth;
                const boxLeft = this.currentX + index * this.boxWidth;
                li.style.transform = `translateX(${boxLeft}px)`;
            });
        },
        go(index) {
            this.activeIndex = index;
            const newX = -index * this.boxWidth;
            this.currentX = newX;
            this.updateBoxesPosition();
            this.updateLiPosition();
        },
        showcaidan() {
            this.caidanone = this.caidanone === "caidanone" ? "caidantwo" : "caidanone";
        },
        showcaidanone() {
            // 更新 caidancss 的位置
            this.caidancss.right = this.caidancss.right === "400px" ? "200px" : "400px";

            // 使用 Vue 的 $set 方法来触发响应式系统检测到 transform 属性变化
            this.$set(this.boxvideocss, 'transform', this.boxvideocss.transform === "translateX(0px)" ? "translateX(200px)" : "translateX(0px)");
        }
    }
};
</script>

<style scoped>
.sex {
    width: 400px;
    height: 800px;
    overflow: hidden;
}

.caidanone {
    position: absolute;
    right: 400px;
    bottom: 0px;
}

.caidantwo {
    position: absolute;
    right: 200px;
    bottom: 0px;
}

.boxvideo {
    width: 400px;
    height: 800px;
    background-color: blue;
    overflow: hidden;
    position: relative;
}

.testsw {
    /* overflow: hidden; */
    width: 400px;
    height: 800px;
}




/* 去掉li前面的黑点 */
ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
    display: flex;
    /* 使用flex布局 */
    overflow: hidden;
    /* 隐藏溢出部分 */
    width: 100%;
    /* ul宽度 */
}

/* 横向排列li */
.nav-list {
    display: flex;
    /* 使用flex布局 */
    margin: 0;
    padding: 0;
}

li {
    display: inline-block;
    margin-right: 8px;
    /* 可选：为每个li元素添加间距 */
    white-space: nowrap;
    /* 确保文本不换行 */
    cursor: pointer;
    /* 添加鼠标手型指示 */
    padding: 6px;
    /* 为li添加内边距 */
    transition: transform 0.3s ease;
    /* 位置变化的过渡效果 */
}

/* 被点击的li的样式 */
li.active {
    font-weight: bold;
    color: red;
    /* 可自定义为你想要的颜色 */
    text-decoration: underline;
    /* 添加下划线 */
    border-bottom: 2px solid red;
    /* 可选：为active状态添加下边框 */
}

.container {
    display: flex;
    /* 使用flex布局 */

    position: relative;
    /* 相对定位 */
    /* 隐藏溢出部分 */
    overflow: hidden;
}

.box {

    position: absolute;
    /* 绝对定位 */
    transition: left 0.3s ease;
    /* 位置变化的过渡效果 */
}
</style>
