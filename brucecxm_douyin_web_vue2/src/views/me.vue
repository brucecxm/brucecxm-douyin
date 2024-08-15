<template>
    <div class="me">

        <div class="header">
            <div class="firstrow"></div>
            <div class="secondrow">
                <div class="touxiang"></div>
                <div class="info">
                    <h6>name</h6>
                    <h6>douyinhao</h6>
                </div>
            </div>
        </div>
        <div class="maininfo"></div>
        <div class="videolist">

        </div>
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
.maininfo {
    width: 100vw;
    height: 30vh;
    background-color: black;
    position: relative;
}

.videolist {
    width: 100vw;
    height: 45vh;
    background-color: wheat;
    position: relative;
}


.header {
    width: 100vw;
    height: 25vh;
    background-color: yellow;
    position: relative;
}

.firstrow {
    width: 100vw;
    height: 2vh;
    background-color: red;
    position: absolute;
    top: 2vh;
}


.secondrow {
    width: 100vw;
    height: 16vh;
    background-color: green;
    position: absolute;
    bottom: 1vh;
    display: flex;
    align-items: center;
    /* 使头像在垂直居中 */
    flex-direction: row;
}

.touxiang {
    width: 14vh;
    height: 14vh;
    border-radius: 7vh;
    background-color: purple;
    z-index: 10;
}
</style>
