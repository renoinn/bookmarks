package com.oomori.app.web.controller

import com.oomori.app.domain.entity.User
import com.oomori.app.domain.service.BookmarkService
import com.oomori.app.web.request.BookmarkRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(path = ["/bookmark"])
class BookmarkController(
        private val bookmarkService: BookmarkService
) {
    @GetMapping("/add")
    fun showForm(): String {
        return "bookmark/add"
    }

    @PostMapping("/add")
    fun add(@RequestBody request: BookmarkRequest, @AuthenticationPrincipal currentUser: User): String {
        bookmarkService.tryCreate(request, currentUser)
        return "redirect:home"
    }
}