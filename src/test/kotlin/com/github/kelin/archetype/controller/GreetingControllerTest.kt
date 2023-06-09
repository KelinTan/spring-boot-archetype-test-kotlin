package com.github.kelin.archetype.controller

import com.github.kelin.archetype.KtTestUtils
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
@WebMvcTest(GreetingController::class)
class GreetingControllerTest : KtTestUtils {
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun testGreeting() {
        val result = mvc.perform(MockMvcRequestBuilders.get("/v1/greeting").param("name", "test"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
            .response.contentAsString.json()
        result verify {
            -"name" eq "Hello, test!"
        }
    }
}
