package com.oomori.app.web.controller

import com.oomori.app.domain.entity.User
import com.oomori.app.domain.service.BookmarkService
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class IndexController(
        val bookmarkService: BookmarkService
) {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/home")
    fun home(
            @AuthenticationPrincipal currentUser: User,
            @PageableDefault(page = 0, size = 20) pageable: Pageable
    ): ModelAndView {
        val bookmarkPage = bookmarkService.findByUser(currentUser, pageable)

        val view = ModelAndView("home")
        view.addObject("bookmarks", bookmarkPage.content)
        view.addObject("page", bookmarkPage)
        return view
    }
}