<template>
  <!-- reference objects with dot notation -->
  <h2>Hello, {{ userObj.fName }} {{ userObj.lName }}</h2>

  <!-- reference arrays with the indexer -->
  <h2>Hello, {{ userArr[0] }} {{ userArr[1] }}</h2>
</template>

<script>
export default {
  data() {
    return {
      userObj: { fName: 'Dilip', lName: 'Malani' },
      userArr: ['Dilip', 'Malani']
    }
  }
}
</script>