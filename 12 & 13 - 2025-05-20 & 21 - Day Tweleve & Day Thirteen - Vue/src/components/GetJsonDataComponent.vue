<template>
    <p><button @click="getPosts">Show All Posts</button></p>
    <ul v-for="post in posts" :key="post.id">
        <li>{{ post }}</li>
    </ul>
    <hr />
    <p>
        id <input type="number" value="1" min="1" max="100" v-model="id" />
        <button @click="getPost">Show Post</button> <br />
        {{ post }}
    </p>
</template>

<script>
    export default {
        data() {
            return {
                id: 0,
                posts: [{}],
                post: {}
            }
        },
        methods: {
            getPosts() {
                fetch('https://jsonplaceholder.typicode.com/posts')
                    .then(response => response.json())
                    .then(data => this.posts = data)
            },
            getPost() {
                fetch('https://jsonplaceholder.typicode.com/posts/' + this.id)
                    .then(response => response.json())
                    .then(data => this.post = data)
            }
        }
    }
</script>