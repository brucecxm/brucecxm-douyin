<template>
    <div class="caidan">
        <testprops :message="parentmessage" ref="child"></testprops>
        <button @click="callChildMethod">Call Child Method</button>
    </div>
</template>

<script>
import testprops from '../../components/shujuchuanshu/testprops.vue';
export default {
    data() {
        return {
            parentmessage: "nnnnnnnn"
        };
    },
    components: {
        testprops
    }
    ,
    methods: {
        callChildMethod() {
            this.$refs.child.someMethod();
            console.log(this.$refs.child.getTestone())

        }
    }

};
</script>

<style scoped></style>
