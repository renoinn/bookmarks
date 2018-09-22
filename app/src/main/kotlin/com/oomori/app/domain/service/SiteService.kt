package com.oomori.app.domain.service

import com.oomori.app.domain.entity.Site
import java.util.*

interface SiteService {
    fun tryCreate(site: Site): Optional<Site>
    fun findById(id: Long): Optional<Site>
}