import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/views/home.vue";

Vue.use(VueRouter);

const router = new VueRouter({
  mode: "history",
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home,
    },
  ],
});

export default router;
