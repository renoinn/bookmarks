package com.oomori.app.domain.service

import com.oomori.app.domain.entity.Bookmark
import com.oomori.app.domain.entity.Site
import com.oomori.app.domain.entity.User
import com.oomori.app.web.request.BookmarkRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface BookmarkService {
    fun tryCreate(site: Site, note: String?, tags: String?, currentUser: User): Optional<Bookmark>
    fun findById(id: Long): Optional<Bookmark>
    fun findByUser(currentUser: User, pageable: Pageable): Page<Bookmark>
}