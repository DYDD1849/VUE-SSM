import LogIn from "@/views/LogIn.vue";
import { createRouter, createWebHistory } from "vue-router";
import MainIndex from "@/views/MainIndex.vue";
import studentReg from "@/views/StudentReg.vue";
import teacherReg from "@/views/TeacherReg.vue";

const routes = [
    {
      path:"/",
      name:"login",
      component:LogIn,
    },
    {
      path:"/studentReg",
      name:"studentReg",
      component:studentReg,
    },
    {
      path:"/teacherReg",
      name:"teacherReg",
      component:teacherReg,
    },
    {
      path:"/main",
      name:"main",
      component:MainIndex
    },
  // {
  //   path: "/",
  //   name: "home",
  //   component: HomeView,
  // },
  // {
  //   path: "/about",
  //   name: "about",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  // },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
