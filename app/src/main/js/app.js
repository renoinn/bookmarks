import Vue from "vue";
import VueRouter from 'vue-router';
import routes from './routes';

var tagForm = new Vue({
    el: '#tag-input',
    data: {
        tags: ""
    },
    methods: {
        onClickHandler: function(tagName) {
            let tagArray = this.tags.split(" ");

            if (tagArray.includes(tagName)) {
                tagArray = tagArray.filter(tag => tag != tagName)
            } else {
                tagArray.push(tagName);
            }

            this.tags = tagArray.join(" ");
        }
    }
});

Vue.use(VueRouter);
const router = new VueRouter({
    routes: routes
});

new Vue({
    el: '#app',
    router
});