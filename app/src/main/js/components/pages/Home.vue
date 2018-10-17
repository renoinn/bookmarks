<template lang="html">
    <div>
        <h1>Sample View</h1>
        <SampleModule></SampleModule>
        <router-link to="/list">Go to QuestionList</router-link>
    </div>
</template>

<script>
import SampleModule from '../modules/SampleModule.vue';

export default {
    components: {
        SampleModule
    }
}
</script>

<style lang="scss" scoped>
@import "../../scss/home.scss";
</style>