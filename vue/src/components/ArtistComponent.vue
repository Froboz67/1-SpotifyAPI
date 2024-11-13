<template>
  <div>
    <label for="artistName">Name of Artist </label>
    <input type="text" v-model="artistName" @keyup.enter="getArtist" />
    <button @click="getArtist">Get Information</button>
  </div>
  <div>
    <label for="q">Search Albums </label>
    <input type="text" v-model="q" @keyup.enter="searchAlbum" />
    <button @click="searchAlbum">Get Information</button>
  </div>
  <!-- <div>
    <label for="q">Name of Album </label>
    <input type="text" v-model="album" @keyup.enter="getAlbum" />
    <button @click="getAlbum">Get Information</button>
  </div> -->
</template>

<script>
import artistService from "../services/ArtistService";
export default {
  data() {
    return {
      artistName: "",
      artist: {},
      albumName: "",
      album: {},
      q: "",
      albumList: {},
      spotifyAlbumId: "",
    };
  },
  methods: {
    getArtist() {
      artistService.getArtist(this.artistName).then((response) => {
        this.artist = response.data;
        this.$store.commit("SET_ARTIST", this.artist);
        this.$router.push({ name: "detail" });
        console.log("artist =", this.artist);
      });
    },
    getAlbum(spotifyAlbumId) {
      artistService.getAlbum(spotifyAlbumId).then((response) => {
        this.albumName = response.data;
        console.log("here is the album", this.albumName.albumType);
        this.$store.commit("SET_ALBUM", this.albumName);
        console.log("album name: ", this.$store.state.album.albumType);
        this.$router.push({ name: "album" });
      });
    },
    searchAlbum() {
      artistService
        .searchAlbum(this.q)
        .then((response) => {
          this.q = response.data;
          console.log(
            "this is the list of albums with the search name",
            this.q
          );
          console.log("this is the first album id", this.q.items[0].id);
          this.spotifyAlbumId = this.q.items[0].id;
          console.log("album id ", this.spotifyAlbumId);

          if (
            this.spotifyAlbumId !== null ||
            this.spotifyAlbumId !== undefined
          ) {
            console.log("YAY!");
          } else {
            console.log("Boo!");
          }
          console.log("line 69");
          this.getAlbum(this.spotifyAlbumId);
        })
        .catch((error) => {
          console.log("bad query name", error);
        });
    },
  },
};
</script>

<style scoped>
</style>