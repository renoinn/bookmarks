package com.oomori.app.domain.entity

import com.oomori.app.annotation.NoArg
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
data class User(

        @Id
        val id: Long = 0,

        @Column(nullable = false, unique = true)
        private val username: String,

        @Column(nullable = false)
        private val password: String,

        @Column(nullable = false)
        private val enabled: Boolean = true,

        @Column(name = "non_expired", nullable = false)
        private val nonExpired: Boolean = true,

        @Column(name = "non_locked", nullable = false)
        private val nonLocked: Boolean = true,

        @Transient
        private var authorities: MutableCollection<out GrantedAuthority> = HashSet(),

        @Column(name = "credentials_non_expired", nullable = false)
        private val credentialsNonExpired: Boolean = true

) : UserDetails {
    override fun isEnabled() = enabled

    override fun getUsername() = username

    override fun isCredentialsNonExpired() = credentialsNonExpired

    override fun getPassword() = password

    override fun isAccountNonExpired() = nonExpired

    override fun isAccountNonLocked() = nonLocked

    override fun getAuthorities() = authorities

    @Column(name = "created_at")
    private lateinit var createdAt: Date

    @Column(name = "updated_at")
    private lateinit var updatedAt: Date

    @PrePersist
    fun onCreate() {
        createdAt = Date()
        updatedAt = createdAt
    }

    @PreUpdate
    fun onUpdate() {
        updatedAt = Date()
    }
}