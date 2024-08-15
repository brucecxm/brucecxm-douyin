<template>
    <div class="container" @mousedown="startDrag" @mouseup="stopDrag" @mousemove="drag" @mouseleave="stopDrag"
        @touchstart="startDrag" @touchend="stopDrag" @touchmove="drag"
        :style="{ width: boxWidth, height: boxHeight * 0.01 + 'rem' }">

        <videoaside-vue class="videoaside"></videoaside-vue>
        <videoarticle-vue class="videoarticleVue"></videoarticle-vue>
        <div v-for="(box, index) in boxes" :key="index" class="box"
            :style="{ top: box.top * 0.01 + 'rem', backgroundColor: box.color, width: boxWidth, height: boxHeigh * 0.01 + 'rem' }">
            <video ref="videos" class="videoone" :src="videonum[index]" preload="true" loop x5-video-player-type="h5-page"
                x5-video-player-fullscreen="false" webkit-playsinline="true" x5-playsinline="true" playsinline="true">
                <p>您的浏览器不支持 video 标签。</p>
            </video>
        </div>



    </div>
</template>

<script>
import oneImg from '@/assets/testvideo/one.mp4';
import twoImg from '@/assets/testvideo/two.mp4';
import threeImg from '@/assets/testvideo/three.mp4';
import fourImg from '@/assets/testvideo/four.mp4';
import videoasideVue from './videoaside.vue';
import videoarticleVue from './videoarticle.vue';
export default {
    components: {
        videoasideVue,
        videoarticleVue
    },
    data() {
        return {
            isDragging: false,
            startY: 0,
            currentY: 0,
            boxWidth: "100%",
            activeIndex: null,
            // 因为受下面函数的影响  如果boxheight的数值太小  滑动会不流畅 因此我用了900 上面乘以0.01
            boxHeight: 900,
            boxes: [],
            videonum: [oneImg, twoImg, threeImg, fourImg],
        };
    },
    created() {
        this.boxes = [
            { color: "black", top: 0, boxtest: "推荐" },
            { color: "black", top: 1 * this.boxHeight, boxtest: "直播" },
            { color: "black", top: 2 * this.boxHeight, boxtest: "关注" },
            { color: "black", top: 3 * this.boxHeight, boxtest: "同城" },
        ];
    },
    mounted() {
        this.updateVideoPlayback();
    },
    methods: {
        startDrag(event) {
            event.preventDefault();
            this.isDragging = true;
            this.startY = this.getEventClientY(event) - this.currentY;
        },
        stopDrag(event) {
            event.preventDefault();
            this.isDragging = false;
            this.updateBoxPositionBasedOnCurrentY();
            this.updateVideoPlayback();
        },
        drag(event) {
            if (this.isDragging) {
                let newY = this.getEventClientY(event) - this.startY;
                newY = Math.max(-(this.boxHeight * (this.boxes.length - 1)), Math.min(newY, 0));
                this.currentY = newY;
                this.updateBoxesPosition();
            }
        },
        getEventClientY(event) {
            return event.type.startsWith("touch") ? event.touches[0].clientY : event.clientY;
        },
        updateBoxesPosition() {
            this.boxes.forEach((box, index) => {
                box.top = this.currentY + index * this.boxHeight;
            });
        },
        updateBoxPositionBasedOnCurrentY() {
            const nearestIndex = Math.round(Math.abs(this.currentY) / this.boxHeight);
            this.currentY = -nearestIndex * this.boxHeight;
            this.updateBoxesPosition();
        },
        updateVideoPlayback() {
            this.$refs.videos.forEach((video, index) => {
                const box = this.boxes[index];
                const boxTop = box.top;
                const boxBottom = boxTop + this.boxHeight;
                const containerHeight = this.boxHeight;

                // 如果视频盒子完全在视口内，播放视频，否则暂停
                if (boxTop >= 0 && boxBottom <= containerHeight) {
                    video.play();
                } else {
                    video.pause();
                }
            });
        },
        go(index) {
            this.activeIndex = index;
            const newY = -index * this.boxHeight;
            this.currentY = newY;
            this.updateBoxesPosition();
            this.updateVideoPlayback();
        },
    },
};
</script>

<style scoped>
.videoaside {
    display: block;
    z-index: 5;
    position: absolute;
    /* 侧边栏的位置 */
    right: 0;
    bottom: 2vh;
}

.videoarticleVue {
    display: block;
    z-index: 5;
    position: absolute;
    /* 侧边栏的位置 */
    left: 0;
    bottom: 2vh;
}

.videoone {

    display: block;
    z-index: 10;
    height: 100vh;
    object-fit: cover;
    margin: 0 auto;
}

.container {
    display: flex;
    flex-direction: column;
    position: relative;
    overflow: hidden;
}

.box {
    position: absolute;
    transition: top 0.3s ease;
}
</style>
