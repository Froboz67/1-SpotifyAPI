<template>
  <div class="header-container">
    <h1>Artist Detail</h1>
    <h1>{{ $store.state.artist.name }}</h1>
    <p>Followers - {{ $store.state.artist.followers.total }}</p>
    <p>Popularity - {{ $store.state.artist.popularity }}/100</p>
  </div>
  <div class="grid-container">
    <div class="box box1">
      <img
        v-if="
          $store.state.artist.images && $store.state.artist.images.length > 1
        "
        :src="$store.state.artist.images[1].url"
        alt="artist-image"
      />
    </div>
    <div class="box box2">
      <h1>Musical Genres</h1>
      <p v-for="genre in $store.state.artist.genres" :key="genre.id">
        {{ genre }}
      </p>
      <button @click="saveArtist">Save Artist to Favorites?</button>
    </div>
  </div>
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
.grid-container {
  display: grid;
  max-width: 1024px;
  grid-template-columns: 1fr 1fr;
  margin: auto;
  gap: 0.75rem;
  padding-top: 0.75rem;
}
.box {
  border: solid 0.4rem rgb(0, 180, 54);
  border-radius: 3rem;
  margin: 0.25rem;
}

.box1 {
  align-content: center;
  padding: 2rem;
}
.box2 {
  align-content: center;
  justify-items: left;
  padding: 2rem;
}
button {
  background-color: silver;
  color: black;
}
img {
  max-width: 100%;
  height: auto;
  margin: 0.5rem;
}

@media (max-width: 1000px) {
  .grid-container {
    display: grid;
    grid-template-columns: 1fr;
    max-width: 506px;
  }
}
@media (max-width: 506px) {
  .box {
    padding: 0.5rem;
  }
  .box2 {
    padding: 2rem;
  }
  img {
    max-width: 90%;
    height: auto;
    margin: 0.5rem;
  }
}
@media (max-width: 350px) {
  .box {
    padding: 0.25rem;
  }
  .box2 {
    padding: 2rem;
  }
  img {
    max-width: 80%;
    height: auto;
  }
}
</style>