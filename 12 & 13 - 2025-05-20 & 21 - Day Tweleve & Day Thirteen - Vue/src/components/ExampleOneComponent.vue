<template>
    <!-- <a :href="link">Vue {{ version }} API Reference</a> -->
     <button @click="redirect">Vue {{ version }} API Reference</button>
</template>

<script>
    export default {
        data() {
            return {
                version: 3,
                link: 'https://vuejs.org/api'
            }
        },
        methods: {
            redirect() {
                window.location.href = this.link 
            }
        }
    }
</script>