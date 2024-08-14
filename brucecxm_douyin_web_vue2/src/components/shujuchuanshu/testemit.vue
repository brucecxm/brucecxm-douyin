<template>
    <div class="caidan">
        <button @click="testone">click</button>
    </div>
</template>

<script>

export default {
    data() {
        return {

        };
    },
    methods: {
        testone() {
            this.$emit('testone', "ddddddddddddd")
            console.log(this.sharedData)
        }
    },
    inject: ['sharedData'],



};
</script>

<style scoped></style>
