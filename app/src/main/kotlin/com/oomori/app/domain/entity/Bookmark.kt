package com.oomori.app.domain.entity

import java.util.*
import javax.persistence.*

@Entity
data class Bookmark(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        val id: Long = 0,

        @Column(name = "user_id", nullable = false)
        val userId: Long = 0,

        @Column(nullable = true)
        val note: String?,

        @Column(nullable = false)
        val createdAt: Date = Date(),

        @Column(nullable = false)
        val updatedAt: Date = Date(),

        @ManyToOne
        val site: Site = Site(),

        @ManyToMany
        @JoinColumns(
                JoinColumn(name = "user_id"),
                JoinColumn(name = "site_id")
        )
        val tags: List<Tag>? = null
)