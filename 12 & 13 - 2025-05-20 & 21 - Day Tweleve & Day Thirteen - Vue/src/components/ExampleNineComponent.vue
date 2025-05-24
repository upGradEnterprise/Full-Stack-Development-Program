<template>
    <p>Counter: {{ count }}</p>
    <button @click="count++">+</button>
    <button @click="count--">-</button>
</template>

<script>
    export default {
        data() {
            return {
                count: 5
            }
        },
        watch: {
            count(newValue) {
                if(newValue > 10) {
                    alert('Value reached max')
                    this.count = 10
                }
                if(newValue < 5) {
                    alert('Value reached min')
                    this.count = 5
                }
            }
        }
    }
</script>