package com.github.kelin.archetype.controller

import com.github.kelin.archetype.entity.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("v1")
class GreetingController {
    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String?): User {
        return User(counter.incrementAndGet(), String.format(template, name))
    }

    companion object {
        private const val template = "Hello, %s!"
    }
}
