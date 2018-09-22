package com.oomori.app.domain.repository

import com.oomori.app.domain.entity.Site
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SiteRepository : JpaRepository<Site, Long> {
    fun findByUrl(url: String): Optional<Site>
}