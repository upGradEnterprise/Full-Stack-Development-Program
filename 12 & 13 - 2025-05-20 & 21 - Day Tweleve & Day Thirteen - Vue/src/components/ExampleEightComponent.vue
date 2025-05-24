<template>
    <p>Personal Profile: {{ profile }}</p>
    <p>Gender: {{ gender }}</p>
    <p>
        Technologies:
        <ul v-for="technology in technologies" :key="technology">
            <li>{{ technology }}</li>
        </ul>
    </p>
    <p>Interests: {{ getInterests }}</p>
    <p v-if="birthYear >= 2000 && birthYear < 2010">You are a Generation Z or iGen</p>
    <p v-else-if="birthYear >= 2010 && birthYear < 2024">You are a Generation Alpha</p>
    <p v-else>You are a Generation Beta</p>
    <p>Subscribed: {{ isSubscribed }}</p>
    <p v-if="isSubscribed">Thank you for Subscribing!</p>
    <p><strong>Fill the Form</strong></p>
    <p>
        Gender:
        <label><input type="radio" value="male" v-model="gender" />Male</label>
        <label><input type="radio" value="female" v-model="gender" />Female</label>
    </p>
    <p>
        Profile:
        <textarea cols="30" rows="10" v-model="profile"></textarea>
    </p>
    <p>
        Technologies:
        <select multiple v-model="technologies">
            <option value="java">Java</option>
            <option value="dotnet">.NET</option>
            <option value="python">Python</option>
            <option value="golang">GoLang</option>
        </select>
    </p>
    <p>
        Interests:
        <label><input type="checkbox" value="movies" v-model="interests" />Movies</label>
        <label><input type="checkbox" value="music" v-model="interests" />Music</label>
        <label><input type="checkbox" value="technology" v-model="interests" />Technology</label>
        <label><input type="checkbox" value="sports" v-model="interests" />Sports</label>
        <label><input type="checkbox" value="reading" v-model="interests" />Reading</label>
    </p>
    <p>
        Birth Year:
        <label><input type="number" value="birthYear" v-model="birthYear" min="2000" max="2025" /></label>
    </p>
    <p>
        <label>Do you want to Subscribe?<input type="checkbox" v-model="isSubscribed" /></label>
    </p>
</template>

<script>
    export default {
        data() {
            return {
                profile: '',
                gender: '',
                technologies: [],
                interests: [],
                birthYear: 2000,
                isSubscribed: false
            }
        },
        computed: {
            getTechnologies() {
                return this.technologies.join(', ')
            },
            getInterests() {
                return this.interests.join(', ')
            }
        }
    }
</script>