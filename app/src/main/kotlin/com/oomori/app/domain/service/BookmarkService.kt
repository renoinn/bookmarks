package com.oomori.app.domain.service

import com.oomori.app.domain.entity.Bookmark
import com.oomori.app.domain.entity.User
import com.oomori.app.web.request.BookmarkRequest
import java.util.*

interface BookmarkService {
    fun tryCreate(bookmark: BookmarkRequest, currentUser: User): Optional<Bookmark>
    fun findById(id: Long): Optional<Bookmark>
}