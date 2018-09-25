import Vue from "vue";

var tagForm = new Vue({
    el: '#tag-input',
    data: {
        tags: "yahoo web"
    },
    onClickHandler: function() {
        this.tags = this.tags.split(" ").push("hoge").join(" ");
    }
});