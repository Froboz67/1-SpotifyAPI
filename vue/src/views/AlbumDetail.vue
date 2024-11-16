<template>
  <!-- <div> -->
  <div class="header-container">
    <h1 id="header">Album Detail</h1>
    <h2 id="album-title">{{ $store.state.album.name }}</h2>
    <h3 id="album-stats">Released - {{ this.releaseDate }}</h3>
    <h3 id="album-stats">Record Label - {{ $store.state.album.label }}</h3>
  </div>
  <div class="grid-container">
    <div class="box box1">
      <img
        v-if="$store.state.album.images && $store.state.album.images.length > 1"
        :src="$store.state.album.images[1].url"
        alt="album-image"
      />
    </div>
    <div class="box box2">
      <h4>{{ $store.state.album.name }}</h4>
      <table>
        <tr>
          <th>Track</th>
          <th>Title</th>
          <th>Length</th>
        </tr>

        <tbody>
          <tr v-for="item in $store.state.album.tracks.items" :key="item.id">
            <td>{{ item.trackNumber }}</td>
            <td>{{ formatSongTitle(item.name) }}</td>
            <td>{{ formatSongLength(item.durationMs) }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
import { format } from "date-fns";

export default {
  data() {
    return {
      album: {},
    };
  },
  methods: {
    formatReleaseDate() {
      this.releaseDate = format(
        new Date(this.$store.state.album.releaseDate),
        "EEEE, MMMM dd, yyyy"
      );
      console.log("date ", this.releaseDate);
    },
    formatSongTitle(item) {
      return item.split("-")[0];
    },
    formatSongLength(length) {
      let minutes = Math.floor(length / 60000); // Calculate minutes
      let seconds = Math.floor((length % 60000) / 1000); // Calculate seconds

      // If seconds are 60 or more, increment the minute and adjust the seconds
      if (seconds >= 60) {
        minutes += Math.floor(seconds / 60); // Add the overflow minutes
        seconds = seconds % 60; // Adjust seconds to less than 60
      }

      // Ensure seconds are always two digits
      const formattedSeconds = seconds.toString().padStart(2, "0");

      const duration = `${minutes}:${formattedSeconds}`;
      return duration;
    },
  },
  created() {
    this.formatReleaseDate();
  },
};
</script>

<style scoped>
.header-container {
  margin-top: 2rem;
}
#header {
  /*the middle param controls the responsive size of the text! 
  the left param is the smallest size it will be and the right
  is the largest it will be */
  font-size: clamp(1rem, 5vw, 3rem);
  color: rgb(0, 180, 54);
}
#album-title {
  font-size: clamp(1rem, 5vw, 3rem);
}
#album-stats {
  font-size: clamp(0.5rem, 3.5vw, 2rem);
}

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
h4 {
  justify-self: center;
}
table {
  width: 100%;
}
td,
th {
  text-align: left;
  padding: 0.25rem;
}
th {
  color: rgb(0, 180, 54);
  font-weight: 900;
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

@media (max-width: 1024px) {
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
    padding: 0.5rem;
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