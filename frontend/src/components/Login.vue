<template>
    <div class="login">
        <main-header/>
        <main>
            <div class="form-container">
                <form class="login-form" v-on:submit.prevent="postLogin" method="POST">
                    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
                    <input type="email" v-model="email" placeholder="Email" required />
                    <input type="password" v-model="password" placeholder="Password" required />
                    <input type="submit" value="Log In" />
                </form>
                <div class="social-login">
                    <button class="social-login--github">
                        <a href="/auth/github">
                            <span>
                                <i class="fab fa-github"></i>
                            </span>Continue with
                            Github
                        </a>
                    </button>
                     <button class="social-login--facebook">
                        <a href="/auth/facebook">
                        <span>
                            <i class="fab fa-facebook"></i>
                        </span>Continue with
                        Facebook
                        </a>
                    </button>
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
    name : "login",

    components: {
        mainHeader,
        mainFooter
    },

    data() {
        return{
            email: "",
            password: ""
        }
    },

    methods: {
        postLogin() {
           
            api
                .postLogin(this.email, this.password)
                .then(response => {
                    this.$router.push("/");
                })
                .catch(error => {
                    this.error.push(error);
                })
        }
    }
};
</script>