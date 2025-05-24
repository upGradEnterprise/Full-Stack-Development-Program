<template>
    <p v-once>Initial Value: {{ counter }}</p>
    <p>Updated Value: {{ counter }}</p>

    <button @click="increment">+</button>
    <button @click="decrement">-</button>
</template>

<script>
    export default {
        data() {
            return {
                counter: 10
            }
        },
        methods: {
            increment() {
                return this.counter++
            },
            decrement() {
                return this.counter--
            }
        }
    }
</script>