package com.oomori.app.web.controller

import com.oomori.app.domain.entity.Site
import com.oomori.app.domain.entity.User
import com.oomori.app.domain.service.BookmarkService
import com.oomori.app.domain.service.TagService
import com.oomori.app.web.request.BookmarkRequest
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping(
        path = ["/bookmark"]
)
class BookmarkController(
        private val bookmarkService: BookmarkService,
        private val tagService: TagService
) {
    @GetMapping("/add")
    fun showForm(@AuthenticationPrincipal currentUser: User): ModelAndView {
        val view = ModelAndView("bookmark/add")
        view.addObject("tags", tagService.findByUserId(currentUser.id))
        return view
    }

    @PostMapping("/add")
    fun add(@ModelAttribute request: BookmarkRequest, @AuthenticationPrincipal currentUser: User): String {
        bookmarkService.tryCreate(
                site = Site(url = request.url, title = request.title),
                note = request.note,
                tags = request.tags,
                currentUser = currentUser)
        return "redirect:" + request.url
    }
}