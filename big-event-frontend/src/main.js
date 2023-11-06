import '@/assets/main.scss'
import 'element-plus/dist/index.css'

import {createApp} from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import router from "@/router";
import {createPinia} from "pinia";
import {createPersistedState} from "pinia-persistedstate-plugin";
import locale from 'element-plus/dist/locale/zh-cn'

const app = createApp(App)
const pinia = createPinia()
const persistedState = createPersistedState();
pinia.use(persistedState)

app.use(pinia)
app.use(router)
app.use(ElementPlus, {locale})
app.mount('#app')
