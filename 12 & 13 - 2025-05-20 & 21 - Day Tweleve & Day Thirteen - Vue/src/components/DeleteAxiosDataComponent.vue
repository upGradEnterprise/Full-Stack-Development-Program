<template>
  <div></div>
</template>

<script>
import axios from 'axios'

export default {
  mounted() {
    axios
      .delete('https://jsonplaceholder.typicode.com/posts/1')
      .then((response) => console.log(response))
  }
}
</script>