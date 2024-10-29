<template>
  <div>
    <label for="artistName">Name of Artist </label>
    <input type="text" v-model="artistName" @keyup.enter="getArtist" />
    <button @click="getArtist">Get Information</button>
  </div>
</template>

<script>
import artistService from "../services/ArtistService";
export default {
  data() {
    return {
      artistName: "",
      artist: {},
    };
  },
  methods: {
    getArtist() {
      artistService.getArtist(this.artistName).then((response) => {
        this.artist = response.data;
        this.$store.commit("SET_ARTIST", this.artist);
        this.$router.push({ name: "detail" });
        console.log(response.data);
      });
    },
  },
};
</script>

<style scoped>
</style>