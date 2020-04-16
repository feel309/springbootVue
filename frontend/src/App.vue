<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style lang="scss">
@import "/assets/scss/config/_variables.scss";
@import "/assets/scss/config/reset.scss";
@import "/assets/scss/config/utils.scss";
@import "/assets/scss/main.scss";
@import "/assets/scss/partials/header.scss";
@import "/assets/scss/partials/footer.scss";
@import "/assets/scss/partials/form.scss";
@import "/assets/scss/partials/socialLogin.scss";
@import "/assets/scss/partials/videoBlock.scss";
@import "/assets/scss/partials/videoPlayer.scss";
@import "/assets/scss/partials/videoRecorder.scss";
@import "/assets/scss/pages/home.scss";
@import "/assets/scss/pages/videoDetail.scss";
@import "/assets/scss/pages/userProfile.scss";
</style>