package com.oomori.app.domain.service.impl

import com.oomori.app.domain.entity.Tag
import com.oomori.app.domain.repository.TagRepository
import com.oomori.app.domain.service.TagService
import org.springframework.stereotype.Service
import java.util.*

@Service
class TagServiceImpl(
        private val tagRepository: TagRepository
) : TagService {
    override fun tryCreate(tag: Tag): Optional<Tag> {
        val existsSite = tagRepository.findBySiteIdAndTagName(tag.siteId, tag.tagName)
        if (existsSite.isPresent)
            return existsSite

        val s = tagRepository.save(tag)
        return findById(s.id)
    }

    override fun findById(id: Long): Optional<Tag> {
        return tagRepository.findById(id)
    }

    override fun findByUserId(userId: Long): List<Tag> {
        return tagRepository.findByUserId(userId)
    }
}