package com.github.kelin.archetype.controller

import com.github.kelin.archetype.entity.User
import com.github.kelin.archetype.mapper.UserMapper
import com.github.kelin.archetype.mapper.UserV2Mapper
import com.github.kelin.archetype.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v2")
class GreetingControllerV2(
    private val userMapper: UserMapper,
    private val userV2Mapper: UserV2Mapper,
    private val userRepository: UserRepository
) {
    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "id") id: Long): User? {
        return userMapper.getUserById(id)
    }

    @GetMapping("/greeting2")
    fun greeting2(@RequestParam(value = "id") id: Long): User? {
        return userV2Mapper.getUserById(id)
    }

    @GetMapping("/greeting3")
    fun greeting3(@RequestParam(value = "id") id: Long): User? {
        return userRepository.findById(id).get()
    }
}
