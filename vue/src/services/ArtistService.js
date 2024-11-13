import axios from 'axios';


export default {

    getArtist(name) {
        return axios.get(`/artist/${name}`);
    },
    saveArtist(artist) {
        return axios.post("/artist", artist);
    },
    getAlbum(album) {
        return axios.get(`/album/${album}`);
    },
    searchAlbum(q) {
        return axios.get(`/search${q}`);
    }

}