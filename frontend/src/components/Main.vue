<template>
  <div class="hello">
    <main-header />
    <main>
      <div class="home-videos">
        <div class="videoBlock">
          <a href>
            <video class="videoBlock__thumbnail" src></video>
            <h4 class="videoBlock__title">영상1</h4>
            <h6 class="videoBlock__views">0 views</h6>
          </a>
        </div>
      </div>
    </main>
    <mainFooter />
  </div>
</template>

<script>
import api from "./spring-proxy";
import mainHeader from "./partials/Header";
import mainFooter from "./partials/Footer";

export default {
  name: "hello",

  components: {
    mainHeader,
    mainFooter
  },

  data() {
    return {
      mainVm: {
        uid: ""
      },
      searchError: false,
      logoutError: false,
      term: "",
      uname: "",
      error: false,
      errors: []
    };
  },

  created() {
    api
      .getHome()
      .then(res => {
        console.log("메인왔나", res.data);

        if (res.data.uid !== "") {
          console.log(res.data.uid + "님 환영합니다");
          this.$store.state.uid = res.data.uid;
        }
        console.log("메인 $store.state.uid", this.$store.state.uid);
      })
      .catch(error => {
        this.searchError = true;
        this.errors.push(error);
        this.error = true;
      });
  },

  methods: {}
};
</script>

<style lang="scss"></style>
