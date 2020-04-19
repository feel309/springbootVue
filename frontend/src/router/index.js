import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import Join from '@/components/Join'
import Login from '@/components/Login'

Vue.use(Router)

const router = new Router({
  mode: "history",
  routes: [
    { path: '/', component: Main },
    { path: '/join', component: Join },
    { path: '/login', component: Login },
    { path: "*", redirect: "/" }
  ]
});

console.log(router,"2. 라우터방식");

export default router;
