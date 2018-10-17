package com.oomori.app.domain.entity

import java.util.*
import javax.persistence.*

@Entity
data class Tag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        val id: Long = 0,

        @Column(nullable = false)
        val userId: Long = 0,

        @Column(nullable = false)
        val siteId: Long = 0,

        @Column(nullable = false)
        val tagName: String = "",

        @Column(nullable = false)
        val createdAt: Date = Date(),

        @Column(nullable = false)
        val updatedAt: Date = Date()

//        @OneToOne
//        @JoinTable(
//                name = "bookmark_tags",
//                joinColumns = [JoinColumn(name = "id", referencedColumnName = "tag_id", insertable = false, updatable = false)],
//                inverseJoinColumns = [JoinColumn(name = "bookmark_id", referencedColumnName = "id", insertable = false, updatable = false)]
//        )
//        val bookmark: Bookmark? = null
)