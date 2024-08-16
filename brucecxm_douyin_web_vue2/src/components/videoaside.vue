<template>
    <div class="videoaside">
        <div class="aside avatar">
            <img src="//p3-pc.douyinpic.com/aweme/100x100/aweme-avatar/tos-cn-avt-0015_8fd03d785381b8f1dabc166e71f16626.jpeg?from=2956013662"
                alt="avatar" style="width: 1rem;height: 1rem;">
        </div>
        <div class="aside like">
        </div>
        <div class="num">{{ videoData.likeNum }}</div>
        <div class="aside comment">
        </div>
        <div class="num">{{ videoData.commentNum }}</div>
        <div class="aside collect">
        </div>
        <div class="num">{{ videoData.collectNum }}</div>
        <div class="aside share ">
        </div>
        <div class="num">{{ videoData.shareNum }}</div>
        <div class="aside music"><img
                src="//p3-pc.douyinpic.com/aweme/100x100/aweme-avatar/tos-cn-avt-0015_8fd03d785381b8f1dabc166e71f16626.jpeg?from=2956013662"
                alt="music" style="width: 1rem;height: 1rem;"></div>
    </div>
</template>
 
<script>

export default {
    props: {
        videoData: Object
    },
    data() {
        return {

        };
    },

};
</script>

<style scoped>
.num {
    color: white;
    font-size: 0.5rem;
}

.aside {
    width: 1rem;
    height: 1rem;

}

/* 父组件的absolute布局影响到了子组件的flex布局 */
.videoaside {
    display: flex;
    flex-direction: column;
    width: 2rem;
    color: rgb(81, 67, 67);
    height: 12rem;
    justify-content: space-between;
    align-items: center;

}

.avatar {
    border-radius: 0.5rem;
    /* background-image: url(); */
    overflow: hidden;

}

.like {
    background-image: url(../assets/home/点赞.png);
    background-size: 1rem 1rem;
}

.comment {
    background-image: url(../assets/home/评论.png);
    background-size: 1rem 1rem;
}

.collect {
    background-image: url(../assets/home/收藏.png);
    background-size: 1rem 1rem;
}

.share {
    background-image: url(../assets/home/转发.png);
    background-size: 1rem 1rem;
}

.music {
    border-radius: 4vh;
    overflow: hidden;
}
</style>
