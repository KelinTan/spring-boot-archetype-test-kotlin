package com.github.kelin.archetype

import com.github.kelin.archetype.TestConstants.USER_DATA
import com.github.kelin.archetype.entity.User
import com.github.kelin.archetype.mapper.UserMapper
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
class UserMapperTest : KtTestUtils {
    @Autowired
    lateinit var userMapper: UserMapper

    @Test
    fun `get user by id`() {
        val user = userMapper.getUserById(1L)!!
        user verify {
            id eq 1
            name eq "test"
        }
    }

    @Test
    fun `insert user`() {
        val user = User(name = "test2")
        userMapper.insertUser(user)

        user.id greater 0
        userMapper.getUserById(user.id) verify {
            name eq "test2"
        }
    }
}
