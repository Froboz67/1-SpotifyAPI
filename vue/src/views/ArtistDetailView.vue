<template>
  <div>Artist Detail:</div>

  <h2>{{ $store.state.artist.name }}</h2>
  <p>{{ $store.state.artist.type }}</p>
  <p>{{ $store.state.artist.popularity }}</p>
  <p v-for="genre in $store.state.artist.genres" :key="genre.id">{{ genre }}</p>
  <img
    v-if="$store.state.artist.images && $store.state.artist.images.length > 1"
    :src="$store.state.artist.images[1].url"
    alt="artist-image"
  />
  <button @click="saveArtist">Save Artist to Favorites?</button>
</template>

<script>
import service from "../services/ArtistService";

export default {
  data() {
    return {
      artist: "",
    };
  },
  methods: {
    saveArtist() {
      let name = this.$store.state.artist.name;
      let id = this.$store.state.artist.id;
      let followers = this.$store.state.artist.followers;
      if (
        this.$store.state.artist.images &&
        this.$store.state.artist.images.length > 1
      ) {
        let image = this.$store.state.artist.images[1].url;
      }
      let artistObj = {
        name,
        id,
        followers,
      };
      console.log(artistObj);
      service
        .saveArtist(artistObj)
        .then((response) => {
          if (response.status === 200) {
            alert("artist saved to database!");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
</style>