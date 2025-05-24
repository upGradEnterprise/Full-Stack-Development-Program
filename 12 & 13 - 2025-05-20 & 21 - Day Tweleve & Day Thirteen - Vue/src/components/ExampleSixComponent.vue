<template>
    <p>{{ counter }}</p>
    <button @click="increment">+</button>
    <button @click="decrement">-</button>

    <form @submit="submitForm">
        <p><button>Submit Form</button></p>
    </form>
</template>

<script>
    export default {
        data() {
            return {
                counter: 0
            }
        },
        methods: {
            submitForm(event) {
                console.log(event)
                event.preventDefault()
                alert('The form was submitted')
            },
            increment() {
                this.counter++
            }, decrement() {
                this.counter--
            }
        }
    }
</script>