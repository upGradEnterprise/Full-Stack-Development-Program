<template>
  <p v-bind:class="['bold', 'italic', isValid ? 'valid' : 'invalid']">
    your text goes here...
  </p>
</template>

<script>
export default {
  data() {
    return {
      isValid: true
    }
  }
}
</script>

<style>
  .bold    { font-weight: bolder }
  .italic  { font-style:  italic }
  .valid   { color: forestgreen  }
  .invalid { color: crimson      }
</style>