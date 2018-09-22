package com.oomori.app.domain.service

import com.oomori.app.domain.entity.Tag
import java.util.*

interface TagService {
    fun tryCreate(tag: Tag): Optional<Tag>
}