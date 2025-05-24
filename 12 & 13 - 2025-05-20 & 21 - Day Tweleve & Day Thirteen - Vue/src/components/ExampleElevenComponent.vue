<template>
    <p v-for="user in legalUsers" :key="user.id">
        {{ user.name }}
    </p>
</template>

<script>
    export default {
        data() {
            return {
                users: [
                    { id: 1, name: 'Ashok', age: 33 },
                    { id: 2, name: 'Babu', age: 35 },
                    { id: 3, name: 'Clinton', age: 17 },
                    { id: 4, name: 'Dude', age: 16}
                ]
            }
        },
        computed: {
            legalUsers() {
                return this.users.filter(user => user.age >= 18).sort((first, second) => {
                    if(first.age > second.age) { return -1 }
                    if(first.age < second.age) { return 1 }
                    return 0
                })
            }
        }
    }
</script>