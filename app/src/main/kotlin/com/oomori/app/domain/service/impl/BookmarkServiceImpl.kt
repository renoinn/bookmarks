package com.oomori.app.domain.service.impl

import com.oomori.app.domain.entity.Bookmark
import com.oomori.app.domain.entity.Site
import com.oomori.app.domain.entity.Tag
import com.oomori.app.domain.entity.User
import com.oomori.app.domain.repository.BookmarkRepository
import com.oomori.app.domain.service.BookmarkService
import com.oomori.app.domain.service.SiteService
import com.oomori.app.domain.service.TagService
import com.oomori.app.web.request.BookmarkRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookmarkServiceImpl(
        private val siteService: SiteService,
        private val tagService: TagService,
        private val bookmarkRepository: BookmarkRepository
) : BookmarkService {
    override fun tryCreate(bookmark: BookmarkRequest, currentUser: User): Optional<Bookmark> {
        val site = siteService.tryCreate(Site(
                url = bookmark.url,
                title = bookmark.title
        )).get()

        val existsBookmark = bookmarkRepository.findBySiteIdAndUserId(site.id, currentUser.id)
        if (existsBookmark.isPresent)
            return existsBookmark

        val b = bookmarkRepository.save(Bookmark(
                siteId = site.id,
                userId = currentUser.id,
                note = bookmark.note
        ))

        val tagNames = bookmark.tags.split(Regex("\\s+"))
        tagNames.forEach {
            tagService.tryCreate(Tag(
                    siteId = site.id,
                    userId = currentUser.id,
                    tagName = it
            ))
        }

        return findById(b.id)
    }

    override fun findById(id: Long): Optional<Bookmark> {
        return bookmarkRepository.findById(id)
    }
}