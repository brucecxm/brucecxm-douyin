<template>
    <div class="caidan">
        <testemit @testone="handleCustomEvent"></testemit>
        <p>{{ good }}</p>
    </div>
</template>

<script>
import testemit from '../../components/shujuchuanshu/testemit.vue';
export default {
    data() {
        return {
            good: "vv",
            data: 'Data from parent'
        };
    },
    components: {
        testemit
    },
    methods: {
        handleCustomEvent(data) {
            this.good = data

            // 处理子组件传递的数据
            console.log('Received from child:', data);
        }
    }
    ,
    provide() {
        return {
            sharedData: this.data
        }
    },

};
</script>
<style scoped></style>
