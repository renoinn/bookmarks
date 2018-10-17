package com.oomori.app.domain.repository

import com.oomori.app.domain.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TagRepository : JpaRepository<Tag, Long> {
    fun findBySiteIdAndTagName(siteId: Long, tagName: String): Optional<Tag>
    fun findByUserId(userId: Long): List<Tag>
}