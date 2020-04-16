<template>
  <div class="mainHeader">
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
      integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
      crossorigin="anonymous"
    />
    <header class="header">
      <div class="header__wrapper">
        <div class="header__column">
          <ul>
            <li>
              <router-link to="/">
                <i class="fab fa-youtube"></i>
              </router-link>
            </li>
          </ul>
        </div>
        <div class="header__column">
          <form action="/search">
            <input style="width:260px" type="text" placeholder="Search by term..." v-model="term" />
            <button style="width:50px" v-on:click.prevent="getSearch">검색</button>
          </form>
        </div>
        <div class="header__column">
          <ul>
            <li v-if="this.$store.state.uid == null">
              <router-link to="/join">join</router-link>
            </li>
            <li v-if="this.$store.state.uid == null">
              <router-link to="/login">login</router-link>
            </li>
            <li style="padding:7px 10px" v-if="this.$store.state.uid != null">
              <router-link to="/videos/upload">Upload</router-link>
            </li>
            <li style="padding:7px 10px" v-if="this.$store.state.uid != null">
              <router-link to="/me">Profile</router-link>
            </li>
            <li
              style="padding:7px 10px"
              v-if="this.$store.state.uid != null"
            >{{ this.$store.state.uid }} 님</li>
            <li style="padding:7px 10px" v-if="this.$store.state.uid != null">
              <button style="width:70px" v-on:click.prevent="getLogout">logout</button>
            </li>
          </ul>
        </div>
      </div>
    </header>
  </div>
</template>

<script>
import api from "../spring-proxy";
export default {
    name: "header",
    data() {
      return {
        uid: ""
      };
    },

    props: {
      mainVm: {
        type: Object,
        default: ""
      }
    },

    mounted() {
      console.log("this.$store.state.uid", this.$store.state.uid);
    },

    methods: {
      getLogout() {
        console.log("1. 로그아웃");
        this.$store.dispatch("getLogout");
        location.href = "/";
      }
    }
}
</script>