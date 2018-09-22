package com.oomori.app.domain.repository

import com.oomori.app.domain.entity.Bookmark
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BookmarkRepository : JpaRepository<Bookmark, Long> {
    fun findBySiteIdAndUserId(siteId: Long, userId: Long): Optional<Bookmark>
}