package com.oomori.app.domain.repository

import com.oomori.app.domain.entity.Bookmark
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookmarkRepository : JpaRepository<Bookmark, Long>, PagingAndSortingRepository<Bookmark, Long> {
    fun findBySiteIdAndUserId(siteId: Long, userId: Long): Optional<Bookmark>
    fun findByUserId(userId: Long, pageable: Pageable): Page<Bookmark>
}