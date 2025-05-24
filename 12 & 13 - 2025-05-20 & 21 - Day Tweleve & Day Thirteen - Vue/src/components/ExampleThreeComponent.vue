<template>
    <p>Welcome, {{ fullName }}</p>
    <p>First Name: <input type="text" @input="getFirstName" /></p>
    <p>Last Name: <input type="text" @input="getLastName" /></p>
</template>

<script>
    export default {
        data() {
            return {
                firstName: '',
                lastName: ''
            }
        },
        methods: {
            getFirstName(event) {
                this.firstName = event.target.value
            },
            getLastName(event) {
                this.lastName = event.target.value
            }
        },
        computed: {
            fullName: {
                get() {
                    return this.firstName + ' ' + this.lastName
                },
                set(value) {
                    const fullName = value.split(' ')
                    this.firstName = fullName[0]
                    this.lastName = fullName[1] 
                }
            }
        }
    }
</script>