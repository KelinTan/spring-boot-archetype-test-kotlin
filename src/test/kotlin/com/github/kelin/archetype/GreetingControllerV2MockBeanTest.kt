package com.github.kelin.archetype

import com.github.kelin.archetype.controller.GreetingControllerV2
import com.github.kelin.archetype.entity.User
import com.github.kelin.archetype.mapper.UserMapper
import com.github.kelin.archetype.mapper.UserV2Mapper
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
@WebMvcTest(GreetingControllerV2::class)
class GreetingControllerV2MockBeanTest : KtTestUtils {
    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var userV2Mapper: UserV2Mapper

    @MockBean
    private lateinit var userMapper: UserMapper

    @Test
    @Throws(Exception::class)
    fun testGreeting() {
        `when`(userMapper.getUserById(1L)).thenReturn(User(1L, "mock"))
        mvc.perform(MockMvcRequestBuilders.get("/v2/greeting").param("id", "1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
            .response.contentAsString.json() verify {
            -"id" eq 1
            -"name" eq "mock"
        }
    }

    @Test
    @Throws(Exception::class)
    fun testGreeting2() {
        `when`(userV2Mapper.getUserById(1L)).thenReturn(User(1L, "mock2"))
        mvc.perform(MockMvcRequestBuilders.get("/v2/greeting2").param("id", "1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
            .response.contentAsString.json() verify {
            -"id" eq 1
            -"name" eq "mock2"
        }
    }
}
