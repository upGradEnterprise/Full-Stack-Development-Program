<template>
  <section>
    <form @submit.prevent="setPost">
      <div>
        <label for="userId">UserID:</label>
        <input type="text" id="userId" v-model="postData.userId">
      </div>
      <div>
        <label for="title">Title: </label>
        <input type="text" id="title" v-model="postData.title">
      </div>
      <div>
        <label for="body">Body: </label>
        <textarea id="body" rows="6" cols="22" v-model="postData.body"></textarea>
      </div>
      <button>Create Post</button>
    </form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      postData: {
        userId: '',
        title:  '',
        body:   ''
      }
    }
  },
  methods: {
    setPost() {
      fetch('http://jsonplaceholder.typicode.com/posts/',{
        method:  'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          userId: this.userId,
          title:  this.title,
          body:   this.body
        })
      })
        .then(response => response.json())
        .then(data => console.log(data))
    }
  }
}
</script>

<style>
html,body{margin:0;padding:0}
section{height:100vh;display:grid;justify-items:center;padding-top:40px}
div{margin:24px auto}
label{font-weight:bolder;display:block;margin-bottom:4px}
</style>