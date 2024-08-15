import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const router = new VueRouter({
  mode: "history", // 使用 HTML5 History 模式，URL 不会带有哈希 (#)
  base: import.meta.env.BASE_URL, // 基础路径，通常与 `vite.config.js` 中的 `base` 保持一致
  routes: [
    {
      path: "/",
      name: "Home",
      component: () => import("@/views/home.vue"), // 通过动态导入实现懒加载，当访问该路由时才加载 Home 组件
    },
    {
      path: "/me",
      name: "Me",
      component: () => import("@/views/me.vue"), // 通过动态导入实现懒加载，当访问该路由时才加载 Me组件
    },
  ],
});

export default router;
