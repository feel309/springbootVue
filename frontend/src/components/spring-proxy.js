import axios from "axios";

const AXIOS = axios.create({
    baseURL: `/`,
    timeout: 1000
});

export default {
    postJoin(user) {
        try {
            let data = JSON.stringify({
                uname: user.fullName,
                uid: user.email,
                upw: user.password
            });

            return axios.post(`/join`, data, {
                headers: {
                    "Content-Type": "application/json"
                }
            });
        } catch (error) {
            console.log(error);
        }

    },

    getHome() {
        console.log("getHome");
        return AXIOS.get(`/home/`);
    },

    postLogin(email, password) {

        console.log(email, password, "이메일+암호");
        let form = new FormData();
        form.append("username", email);
        form.append("password", password);
        return axios.post(`/login`, form);
    },

    getLogout(uid) {
        console.log(uid,"UID-----");
        return axios.get(`/logout/`+ uid);
    }

}