<template>
    <div class="testsw">
        <div class="container" @mousedown="startDrag" @mouseup="stopDrag" @mousemove="drag" @mouseleave="stopDrag"
            @touchstart="startDrag" @touchend="stopDrag" @touchmove="drag"
            :style="{ width: boxWidth + 'px', height: boxHeight + 'px' }">
            <div v-for="(box, index) in boxes" :key="index" class="box"
                :style="{ top: box.top + 'px', backgroundColor: box.color, width: boxWidth + 'px', height: boxHeight + 'px' }">
                <video ref="videos" class="videoone" :src="videonum[index]" preload="true" loop
                    x5-video-player-type="h5-page" x5-video-player-fullscreen="false" webkit-playsinline="true"
                    x5-playsinline="true" playsinline="true">
                    <p>您的浏览器不支持 video 标签。</p>
                </video>
            </div>
        </div>
        <div class="guanzhu"></div>
    </div>
</template>

<script>
import oneImg from '@/assets/testvideo/one.mp4';
import twoImg from '@/assets/testvideo/two.mp4';
import threeImg from '@/assets/testvideo/three.mp4';
import fourImg from '@/assets/testvideo/four.mp4';


export default {
    data() {
        return {
            isDragging: false,
            startY: 0,
            currentY: 0,
            boxWidth: 400,
            activeIndex: null,
            boxHeight: 800,
            boxes: [],
            videonum: [oneImg, twoImg, threeImg, fourImg],
        };
    },
    created() {
        this.boxes = [
            { color: "red", top: 0, boxtest: "推荐" },
            { color: "blue", top: 1 * this.boxHeight, boxtest: "直播" },
            { color: "yellow", top: 2 * this.boxHeight, boxtest: "关注" },
            { color: "pink", top: 3 * this.boxHeight, boxtest: "同城" },
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
.guanzhu {
    width: 200px;
    height: 200px;
    background-color: red;
    z-index: 10;
    position: absolute;
    top: 200px;
    left: 200px;
}

.videoone {
    display: block;
    z-index: 10;
    width: 100%;
    height: 100%;
    object-fit: cover;
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
