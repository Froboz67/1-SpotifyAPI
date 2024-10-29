import axios from 'axios';


export default {

    getJoke() {
        return axios.get("/joke");
    },
    saveJoke(joke) {
        return axios.post("/joke", joke);
    }
}
