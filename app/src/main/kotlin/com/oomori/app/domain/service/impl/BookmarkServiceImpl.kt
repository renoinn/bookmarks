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
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookmarkServiceImpl(
        private val siteService: SiteService,
        private val tagService: TagService,
        private val bookmarkRepository: BookmarkRepository
) : BookmarkService {
    override fun tryCreate(site: Site, note: String?, tags: String?, currentUser: User): Optional<Bookmark> {
        val site = siteService.tryCreate(Site(
                url = site.url,
                title = site.title
        )).get()

        val existsBookmark = bookmarkRepository.findBySiteIdAndUserId(site.id, currentUser.id)
        if (existsBookmark.isPresent)
            return existsBookmark

        val tagList = mutableListOf<Tag>()
        tags?.let {
            val tagNames = it.split(Regex("\\s+"))
            tagNames.forEach {tagName ->
                val t = tagService.tryCreate(Tag(
                        userId = currentUser.id,
                        siteId = site.id,
                        tagName = tagName
                )).get()
                tagList.add(t)
            }
        }
        val b = bookmarkRepository.save(Bookmark(
                site = site,
                userId = currentUser.id,
                note = note,
                tags = tagList
        ))

        return findById(b.id)
    }

    override fun findById(id: Long): Optional<Bookmark> {
        return bookmarkRepository.findById(id)
    }

    override fun findByUser(currentUser: User, pageable: Pageable): Page<Bookmark> {
        return bookmarkRepository.findByUserId(userId = currentUser.id, pageable = pageable)
    }
}