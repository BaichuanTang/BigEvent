<script setup>
    import {ref,onMounted} from 'vue'
    //声明响应式数据 ref  响应式对象有一个内部的属性value
    const count = ref(0); //在组合式api中,一般需要把数据定义为响应式数据
    //const count=0;

    //声明函数
    function increment(){
        count.value++;
    }

    //声明钩子函数 onMounted
    onMounted(()=>{
        console.log('vue 已经挂载完毕了...');
    });
</script>

<template>
    <!-- 写html元素 -->
    <button @click="increment">count: {{ count }}</button>
</template>