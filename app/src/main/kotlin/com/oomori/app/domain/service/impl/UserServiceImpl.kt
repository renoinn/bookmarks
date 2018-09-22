package com.oomori.app.domain.service.impl

import com.oomori.app.domain.entity.User
import com.oomori.app.domain.repository.UserRepository
import com.oomori.app.domain.service.UserService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
        private val userRepository: UserRepository
) : UserService {
    override fun tryCreate(user: User): Optional<User> {
        val existsUser = findByUsername(user.username)
        if (existsUser.isPresent)
            return existsUser

        val u = userRepository.save(user.copy(password = BCryptPasswordEncoder().encode(user.password)))
        return findById(u.id)
    }

    override fun findByUsername(username: String): Optional<User> {
        return userRepository.findByUsername(username)
    }

    override fun findById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }
}