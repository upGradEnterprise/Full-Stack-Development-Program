<template>
    <div class="card" v-for="person in people" :key="person.id">
        <h2>{{ person.name }}</h2>
        <p class="card sub" v-for="friend in person.friends" :key="friend">
            {{ friend }}
        </p>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                people: [
                    { id: 1, name: 'Rajinikanth', friends: ['Amitabh', 'Chiranjeevi', 'Shahrukh'] },
                    { id: 2, name: 'Kamal Hassan', friends: ['Rajinikanth', 'Amitabh'] },
                    { id: 3, name: 'Chiranjeevi', friends: ['Amitabh'] }
                ]
            }
        }
    }
</script>

<style>
    .card { width: 30rem; margin: 1rem auto; padding: .5rem; border: 1px solid black; }
    .sub { width: initial; margin: .5rem; }
</style>