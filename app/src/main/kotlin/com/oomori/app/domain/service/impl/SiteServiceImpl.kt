package com.oomori.app.domain.service.impl

import com.oomori.app.domain.entity.Site
import com.oomori.app.domain.repository.SiteRepository
import com.oomori.app.domain.service.SiteService
import org.springframework.stereotype.Service
import java.util.*

@Service
class SiteServiceImpl(
        private val siteRepository: SiteRepository
) : SiteService {
    override fun tryCreate(site: Site): Optional<Site> {
        val existsSite = siteRepository.findByUrl(site.url)
        if (existsSite.isPresent)
            return existsSite

        val s = siteRepository.save(site)
        return findById(s.id)
    }

    override fun findById(id: Long): Optional<Site> {
        return siteRepository.findById(id)
    }
}