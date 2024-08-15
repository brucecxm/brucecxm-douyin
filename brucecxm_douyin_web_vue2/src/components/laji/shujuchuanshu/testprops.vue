<template>
    <div class="caidan">
        {{ message }}
    </div>
</template>

<script>
import oneImg from '@/assets/one.mp4';
import twoImg from '@/assets/two.mp4';
import threeImg from '@/assets/three.mp4';
import fourImg from '@/assets/four.mp4';

export default {
    data() {
        return {
            testone: "ssssdwadawdawfawfawfssss"
        };
    },
    props: {
        message: ""
    },
    methods: {
        someMethod() {
            console.log("ssssssssssssssssffffffffffff")
        },
        getTestone() {
            return this.testone;
        }
    }

};
</script>

<style scoped></style>
