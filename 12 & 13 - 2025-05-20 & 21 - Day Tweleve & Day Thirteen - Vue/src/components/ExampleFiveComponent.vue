<template>
    <p>Welcome, {{ name }}</p>
    <input type="text" @input="getInput($event, 'Malani')" />
</template>

<script>
    export default {
        data() {
            return {
                name: ''
            }
        },
        methods: {
            getInput(event, lastName) {
                this.name = event.target.value + ' ' + lastName
                console.log(event)
            }
        }
    }
</script>