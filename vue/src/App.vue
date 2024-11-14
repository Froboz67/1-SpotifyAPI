<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link id="text" v-bind:to="{ name: 'home' }">Home</router-link
      >&nbsp;|&nbsp;
      <router-link id="text" v-bind:to="{ name: 'artist' }"
        >Artist / Album Search</router-link
      >&nbsp;|&nbsp;
      <router-link
        id="text"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>

<style>
#capstone-app {
  text-align: center;
}
* {
  background-color: #000000;
  font-family: "Host Grotesk", Arial, Helvetica, sans-serif;
  color: white;
}
#nav,
#text {
  margin: 1rem;
}
#text {
  color: rgb(0, 180, 54);
  font-size: 1.5rem;
}
</style>
