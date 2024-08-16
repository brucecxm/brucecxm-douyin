import Vue from "vue";
import { createPinia, PiniaVuePlugin } from "pinia";

import App from "./App.vue";
import router from "./router";
import "./assets/main.css";

Vue.config.productionTip = false;

// 创建事件总线实例
Vue.prototype.$bus = new Vue();

// EventBus.js
Vue.use(PiniaVuePlugin);

new Vue({
  router,
  pinia: createPinia(),
  render: (h) => h(App),
}).$mount("#app");
