<template>
    <div class="home">
        <header-vue class="header"></header-vue>
        <div class="videobox"><videobox-vue></videobox-vue></div>
        <footer-vue></footer-vue>
    </div>
</template>
<script>
import footerVue from '../components/footer.vue'
import headerVue from '../components/header.vue'
import videoboxVue from '../components/videobox.vue'
export default {
    data() {
        return {

        }
    },
    components: {
        videoboxVue,
        headerVue,
        footerVue
    },
    methods: {

    }
}

</script>
<style scoped>
.header {

    position: absolute;
    top: 0;
    z-index: 5;
}


/* 视频播放区域 */
.videobox {
    width: 100%;
    height: 90vh;
    background-color: yellow;
}
</style>