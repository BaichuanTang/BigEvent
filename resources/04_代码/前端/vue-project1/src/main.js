import { createApp } from 'vue'//导入vue
import ElementPlus from 'element-plus'//导入element-plus
import 'element-plus/dist/index.css'//导入element-plus的样式
import App from './App.vue'//导入app.vue
import locale from 'element-plus/dist/locale/zh-cn.js'

const app = createApp(App)//创建应用实例

app.use(ElementPlus,{locale})//使用element-plus
app.mount('#app')//控制html元素