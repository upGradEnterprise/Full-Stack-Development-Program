<template>
  <div>
    <h2>{{ post.id }} {{ post.title }}</h2>
    <p>{{ post.body }}</p>  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      post: {}
    }
  },
  mounted() {
    axios
      .get('https://jsonplaceholder.typicode.com/posts/1')
      .then((response) => {
        this.post = response.data
        console.log(response.data)
      })
  }
}
</script>