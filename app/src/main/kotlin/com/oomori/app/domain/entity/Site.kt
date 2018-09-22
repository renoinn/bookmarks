package com.oomori.app.domain.entity

import java.util.*
import javax.persistence.*

@Entity
data class Site(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        val id: Long = 0,

        @Column(nullable = false)
        val url: String = "",

        @Column(nullable = false)
        val title: String = "",

        @Column(nullable = false)
        val createdAt: Date = Date(),

        @Column(nullable = false)
        val updatedAt: Date = Date()
)