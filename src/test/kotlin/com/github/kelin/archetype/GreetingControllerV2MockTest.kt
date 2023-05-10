package com.github.kelin.archetype

import com.github.kelin.archetype.controller.GreetingControllerV2
import com.github.kelin.archetype.entity.User
import com.github.kelin.archetype.mapper.UserMapper
import com.github.kelin.archetype.mapper.UserV2Mapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class GreetingControllerV2MockTest : KtTestUtils {
    @InjectMocks
    private lateinit var greetingControllerV2: GreetingControllerV2

    @Mock
    private lateinit var userV2Mapper: UserV2Mapper

    @Mock
    private lateinit var userMapper: UserMapper

    @Test
    fun testGreeting() {
        `when`(userMapper.getUserById(1L)).thenReturn(User(1L, "mock"))
        greetingControllerV2.greeting(1L) verify {
            id eq 1L
            name eq "mock"
        }
    }

    @Test
    fun testGreeting2() {
        `when`(userV2Mapper.getUserById(1L)).thenReturn(User(1L, "mock2"))
        greetingControllerV2.greeting2(1L) verify {
            id eq 1L
            name eq "mock2"
        }
    }
}
