package com.github.kelin.archetype.controller

import com.github.kelin.archetype.KtTestUtils
import com.github.kelin.archetype.TestConstants.USER_DATA
import com.github.kelin.archetype.TestConstants.USER_V2_DATA
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.transaction.annotation.Transactional

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SqlGroup(Sql(USER_DATA), Sql(USER_V2_DATA))
@Transactional
class GreetingControllerV2Test : KtTestUtils {
    @Autowired
    lateinit var mvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun testGreeting() {
        mvc.perform(MockMvcRequestBuilders.get("/v2/greeting").param("id", "1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
            .response.contentAsString.json() verify {
            -"id" eq 1
            -"name" eq "test"
        }
    }

    @Test
    @Throws(Exception::class)
    fun testGreeting2() {
        mvc.perform(MockMvcRequestBuilders.get("/v2/greeting2").param("id", "1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
            .response.contentAsString.json() verify {
            -"id" eq 1
            -"name" eq "test_v2"
        }
    }

    @Test
    @Throws(Exception::class)
    fun testGreeting3() {
        mvc.perform(MockMvcRequestBuilders.get("/v2/greeting3").param("id", "1"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print())
            .andReturn()
            .response.contentAsString.json() verify {
            -"id" eq 1
            -"name" eq "test"
        }
    }
}
