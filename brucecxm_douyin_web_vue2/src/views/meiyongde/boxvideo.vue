<template>
    <div class="sex">
        <caidan :style="caidancss"></caidan>

        <div :style="boxvideocss">
            <button @click="showcaidanone">show</button>

        </div>
    </div>
</template>

<script>
import caidan from '../components/caidan.vue';

export default {
    data() {
        return {
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
        caidan
    },
    methods: {
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
</style>
