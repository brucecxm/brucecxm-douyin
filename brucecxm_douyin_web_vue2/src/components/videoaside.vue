<template>
    <div class="videoaside">
        <div class="aside avatar">
            <img src="//p3-pc.douyinpic.com/aweme/100x100/aweme-avatar/tos-cn-avt-0015_8fd03d785381b8f1dabc166e71f16626.jpeg?from=2956013662"
                alt="avatar" style="width: 9vh;height: 9vh;">
        </div>
        <div class="aside like"></div>
        <div class="aside comment"></div>
        <div class="aside collect"></div>
        <div class="aside share "></div>
        <div class="aside music"><img
                src="//p3-pc.douyinpic.com/aweme/100x100/aweme-avatar/tos-cn-avt-0015_8fd03d785381b8f1dabc166e71f16626.jpeg?from=2956013662"
                alt="music" style="width: 9vh;height: 9vh;"></div>
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
.aside {
    width: 8vh;
    height: 8vh;
    margin: 1vh;
}

.videoaside {
    width: 15vw;
    height: 50vh;
    display: flex;
    flex-direction: column;
}

.avatar {
    border-radius: 4vh;
    /* background-image: url(); */
    overflow: hidden;
    display: flex;
}

.like {
    background-image: url(../assets/home/点赞.png);
    background-size: 8vh 8vh;
}

.comment {
    background-image: url(../assets/home/评论.png);
    background-size: 8vh 8vh;
}

.collect {
    background-image: url(../assets/home/收藏.png);
    background-size: 8vh 8vh;
}

.share {
    background-image: url(../assets/home/转发.png);
    background-size: 8vh 8vh;
}

.music {
    border-radius: 4vh;
    overflow: hidden;
    display: flex;
}
</style>
