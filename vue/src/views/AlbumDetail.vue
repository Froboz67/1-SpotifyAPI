<template>
  <!-- <div> -->
  <div class="header-container">
    <h1>Album Detail</h1>
    <h2>{{ $store.state.album.name }}</h2>
    <h3>Released - {{ this.releaseDate }}</h3>
    <h3>Record Label - {{ $store.state.album.label }}</h3>
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

/* these media queries don't really accomplish
what I'm looking for, but I'm good for now. I will come 
back and visit this after I learn more */

@media (max-width: 1000px) {
  .grid-container {
    display: grid;
    grid-template-columns: 1fr;
    max-width: 506px;
  }

  @media (max-width: 506px) {
    .box1,
    .box2 {
      padding: 0.5rem;
    }
  }
  @media (max-width: 350px) {
    .box1,
    .box2 {
      padding: 0.25rem;
    }
  }
}
</style>