import Vue from "vue";
import Vuex from "vuex";
import api from "../components/spring-proxy";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    uid: ""
  },
  mutations: {},
  actions: {
    getLogout() {
      console.log("2. 헤더 로그아웃");
      return api.getLogout(this.state.uid);
    }
  },
  
  modules: {},
  getters: {}
});