import Vue from "vue";

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