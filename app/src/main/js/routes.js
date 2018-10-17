import Home from './components/pages/Home.vue';
import BookmarkAdd from './components/pages/bookmark/Add.vue';

export default [
    {
        path: '/',
        component: Home
    },
    {
        path: '/bookmark/add',
        component: BookmarkAdd
    }
];