<template>
  <div class="hello">
    <h1>{{ message }}</h1>
  </div>
</template>

<script>
export default {
  data() {
    return { message: 'Hello, World!' }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
  h1 { color: blue;}
</style>