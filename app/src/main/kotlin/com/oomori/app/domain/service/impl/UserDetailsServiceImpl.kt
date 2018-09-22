package com.oomori.app.domain.service.impl

import com.oomori.app.domain.entity.User
import com.oomori.app.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserDetailsServiceImpl : UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String): UserDetails {
        val user = findByUsername(username)
        if (!user.isPresent)
            throw UsernameNotFoundException("Username $username is not found")
        if (!user.get().isAccountNonLocked)
            throw UsernameNotFoundException("Username $username is locked")
        return user.get().copy(authorities = getAuthorities())
    }

    private fun getAuthorities() = AuthorityUtils.createAuthorityList("ROLE_USER")

    fun findByUsername(username: String): Optional<User> {
        val user = userRepository.findByUsername(username)
        return user
    }
}