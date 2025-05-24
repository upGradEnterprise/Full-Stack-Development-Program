<template>
    <button @click="isMenuOpen = true">Open Menu</button>
    <main-menu v-show="isMenuOpen" @closeMenu="closeMenu" />
    <p>{{ company }}</p>
</template>

<script>
    import MainMenu from './MainMenu.vue'

    export default {
        components: { MainMenu },
        data() {
            return {
                company: '',
                isMenuOpen: false
            }
        },
        methods: {
            closeMenu(data) {
                this.isMenuOpen = false
                this.company = data
            }
        }
    }
</script>