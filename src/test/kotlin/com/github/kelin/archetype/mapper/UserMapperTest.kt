package com.github.kelin.archetype.mapper

import com.github.kelin.archetype.TestConstants.USER_DATA
import com.github.kelin.archetype.entity.User
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(USER_DATA)
@Transactional
class UserMapperTest {
    @Autowired
    lateinit var userMapper: UserMapper

    @Test
    fun `get user by id`() {
        val user = userMapper.getUserById(1L)!!
        user should {
            it.id shouldBe 1
            it.name shouldBe "test"
        }
    }

    @Test
    fun `insert user`() {
        val user = User(name = "test2")
        userMapper.insertUser(user)

        user.id shouldBeGreaterThan 0
        userMapper.getUserById(user.id) should {
            it.shouldNotBeNull()
            it.name shouldBeEqual "test2"
        }
    }
}
