package com.oomori.app.task

import com.oomori.app.domain.entity.User
import com.oomori.app.domain.service.UserService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class SetupUserDataTask(
        private val userService: UserService
) : ApplicationListener<ContextRefreshedEvent> {
    private var alreadySetup = false

    @Transactional
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        if (alreadySetup) return
        alreadySetup = true

        createUserIfNotFound(1, "test@gmail.com", "test")
    }

    @Transactional
    fun createUserIfNotFound(id: Long, username: String, password: String): User {
        val user = User(id = id, username = username, password = password)
        var retrieval = userService.tryCreate(user)
        if (!retrieval.isPresent)
            retrieval = userService.findByUsername(username)
        return retrieval.get()
    }
}