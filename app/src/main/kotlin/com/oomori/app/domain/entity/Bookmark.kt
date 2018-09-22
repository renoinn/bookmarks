package com.oomori.app.domain.entity

import java.util.*
import javax.persistence.*

@Entity
data class Bookmark(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        val id: Long = 0,

        @Column(nullable = false)
        val userId: Long = 0,

        @Column(nullable = false)
        val siteId: Long = 0,

        @Column(nullable = true)
        val note: String = "",

        @Column(nullable = false)
        val createdAt: Date = Date(),

        @Column(nullable = false)
        val updatedAt: Date = Date()
)