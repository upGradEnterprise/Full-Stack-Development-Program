<template>
  <form @submit.prevent="updatePost">
    <button>Update Post</button>
  </form>
</template>

<script>
export default {
  methods: {
    updatePost() {
      fetch('https://jsonplaceholder.typicode.com/posts/1',{
        method:  'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          userId: 1,
          id:     1,
          title:  'Important Update',
          body:   'End-to-End Training on Java Full Stack with Spring Boot + Testing & Vue as Front-end has Concluded.'
        })
      })
        .then(response => response.json())
        .then(data => console.log(data))
    }
  }
}
</script>