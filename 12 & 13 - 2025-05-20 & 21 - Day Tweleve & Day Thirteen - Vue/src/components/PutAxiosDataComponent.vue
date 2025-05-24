<template>
  <div></div>
</template>

<script>
import axios from 'axios'

export default {
  mounted() {
    axios
      .put('https://jsonplaceholder.typicode.com/posts/1', {
        id: '1',
        userId: '1',
        title:  'Article title',
        body:   'Article body content'
      })
      .then((response) => console.log(response))
  }
}
</script>