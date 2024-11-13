<template>
  <div>
    <h1>Album Detail</h1>
    <h2>Album name - "{{ $store.state.album.name }}"</h2>
    <img
      v-if="$store.state.album.images && $store.state.album.images.length > 1"
      :src="$store.state.album.images[1].url"
      alt="album-image"
    />
    <p>label {{ $store.state.album.label }}</p>
    <h2>Album Tracks</h2>
    <p>{{ $store.state.album.tracks.items[0].name }}</p>
    <p v-for="item in $store.state.album.tracks.items" :key="item.id">
      {{ item.name }}
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      album: {},
    };
  },
};
</script>

<style scoped>
</style>