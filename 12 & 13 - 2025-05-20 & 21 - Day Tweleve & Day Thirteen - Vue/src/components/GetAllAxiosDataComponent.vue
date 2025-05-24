<template>
  <div v-for="post in posts" :key="post.id">
    <h2>{{ post.id }} {{ post.title }}</h2>
    <p>{{ post.body }}</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      posts: []
    }
  },
  mounted() {
    axios
      .get('https://jsonplaceholder.typicode.com/posts/')
      .then((response) => {
        this.posts = response.data
      })
  }
}
</script>