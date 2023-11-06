<!-- <script>
  //写数据
  export default{
    data(){
      return {
        msg:'上海'
      }
    }
  }
</script> -->
<script setup>
  import {ref} from 'vue';
  //调用ref函数,定义响应式数据
  const msg = ref('西安');

  //导入 Api.vue文件
  import ApiVue from './Api.vue'
  //导入Article.vue文件
  import ArticleVue from './Article.vue'
</script>

<template>
  <!-- html -->
  <!-- <h1>北京</h1> -->
  <!-- <h1>{{ msg }}</h1>
  <br>
  <ApiVue/> -->

  <ArticleVue/>
</template>

<style scoped>
  /* 样式 */
  h1{
    color: red;
  }
</style>
