<template>
    <div>
        <p>Main Menu</p>
        <p><input type="text" v-model="company"></p>
        <button @click="$emit('closeMenu', company)">Close Menu</button>
    </div>
</template>

<script>
    export default {
        emits: {
            closeMenu(company) {
                if(!company) return false
                else return true
            }
        },
        data() {
            return {
                company: ''
            }
        }
    }
</script>