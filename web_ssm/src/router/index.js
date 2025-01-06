import { createRouter, createWebHistory } from "vue-router";
import studentReg from "@/views/StudentReg.vue";
import teacherReg from "@/views/TeacherReg.vue";
import StudentMainIndex from "@/views/StudentMainIndex.vue";
import TeacherMainIndex from "@/views/TeacherMainIndex.vue";
import ManagerMainIndex from "@/views/ManagerMainIndex.vue";
import LogIn from "@/views/LogIn.vue";
import ChatTest from "@/views/ChatRoom/chatTest.vue";

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
      path:"/StudentMain",
      name:"studentMain",
      component:StudentMainIndex,
    },
    {
      path:"/GoChat/:id",
      name:"GoChat",
      component:ChatTest,
    },
    {
      path:"/TeacherMain",
      name:"teacherMain",
      component:TeacherMainIndex,
      children:[
        {
          path:"",
          component: () => import("../views/TeacherEnterCourse/TeacherCourse.vue"),
        }
        ,
        {
          path: "/TeacherEnterCourse/:cno",
          name:'TeacherEnterCourse',
          component: () => import("../views/TeacherEnterCourse/TeacherEnterCourse.vue"),
        }
      ]
    },
    {
      path:"/ManagerMain",
      name:"managerMain",
      component:ManagerMainIndex,
      children:[
        {
          path: "/ManageStudent",
          component: () => import("../views/ManageChild/ManageStudent.vue"),
        },
        {
          path: "/ManageTeacher",
          component: () => import("../views/ManageChild/ManageTeacher.vue"),
        },
        {
          path: "/ManageSCroot",
          component: () => import("../views/ManageChild/ManageSCroot.vue"),
          children:[
            {
              path:"",
              component: () => import("../views/ManageChild/ManageCourse.vue"),
            }
            ,
            {
              path: "/ManageStudentScore/:cno",
              name:'ManageStudentScore',
              component: () => import("../views/ManageChild/ManageStudentScore.vue"),
            }
          ]
        },
      ]
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
