<template>
    <example-twelve-component name="Dilip" />
    <example-fourteen-component greet="Night" />

    <example-twelve-component name="Mahesh" />
    <example-fourteen-component greet="Evening" />

    <example-twelve-component name="Ramesh" />
    <example-fourteen-component greet="Morning" />
</template>

<script>
    import ExampleTwelveComponent from './ExampleTwelveComponent.vue'
    import ExampleFourteenComponent from './ExampleFourteenComponent.vue'

    export default {
        components: { 
            ExampleTwelveComponent, 
            ExampleFourteenComponent 
        }
    }
</script>