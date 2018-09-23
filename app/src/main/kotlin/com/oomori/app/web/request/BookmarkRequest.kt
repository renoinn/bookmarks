package com.oomori.app.web.request

data class BookmarkRequest(
        val url: String = "",

        val title: String = "",

        val note: String?,

        val tags: String?
)