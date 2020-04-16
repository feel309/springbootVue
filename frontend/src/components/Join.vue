<template>
    <div class="join">
        <main-header />
        <main>
            <div class="form-container">
                <form class="signup-form" v-on:submit.prevent="postJoin" method="POST">
                    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
                    <input type="text" v-model="user.fullName" placeholder="Full Name" required />
                    <input type="email" v-model="user.email" placeholder="Email" required />
                    <input type="password" v-model="user.password" placeholder="Password" required/>
                    <input type="password" v-model="user.verifyPassword" placeholder="Verify Password" required />

                    <input type="submit" value="Join Now"/>
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
    name: "join",

    components: {
        mainHeader,
        mainFooter
    },

    data() {
        return{
            response: [],
            errors: [],
            user: {
                fullName:"",
                email:"",
                password:"",
                verifyPassword:""
            },
            showResponse: false,
            retrievedUser : {},
            showRetrievedUser: false
        };
    },

    methods: {
        postJoin() {
            let user = this.user;

            if(user.password !== user.verifyPassword) {
                alert("비밀번호를 확인하세요");
                return;
            }

            api
                .postJoin(this.user)
                .then(response => {
                    console.log("조인왔나", response.data);
                    this.showResponse = true;
                    this.$router.push("/login");
                })
                .catch(error => {
                    this.errors.push(error);
                });
        }
    }
};
</script>