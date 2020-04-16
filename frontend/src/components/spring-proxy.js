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
        return AXIOS.get('/home/');
    }

}