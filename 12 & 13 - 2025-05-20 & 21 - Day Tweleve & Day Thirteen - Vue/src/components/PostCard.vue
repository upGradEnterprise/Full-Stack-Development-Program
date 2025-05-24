<template>
    <div class="card">{{ content }}</div>
</template>

<script>
    export default {
        props: ['content']
    }
</script>

<style>
    .card {
        max-width: 250px;
        text-align: center;
        margin: 2rem auto;
        padding: .6rem .8rem;
        border: .1rem solid #94A3B8;
        color: #64748B;
    }
</style>