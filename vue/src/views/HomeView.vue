<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <dad-joke />
  </div>
</template>

<script>
import DadJoke from "../components/DadJoke.vue";
export default {
  components: { DadJoke },
};
</script>
