<template>
  <div>
    <h2>{{ joke }}</h2>
    <button @click="saveJoke">Save Joke to Favorites?</button>
  </div>
</template>

<script>
import service from "../services/JokeService";
export default {
  data() {
    return {
      joke: "",
    };
  },
  methods: {
    saveJoke() {
      let jokeObj = {
        joke: this.joke,
      };
      console.log(jokeObj);
      service
        .saveJoke(jokeObj)
        .then((response) => {
          if (response.status === 201) {
            alert(
              `Status Code: ${response.status} - ${response.statusText} joke saved to database!`
            );
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  created() {
    service.getJoke().then((response) => {
      this.joke = response.data;
    });
  },
};
</script>

<style scoped>
</style>