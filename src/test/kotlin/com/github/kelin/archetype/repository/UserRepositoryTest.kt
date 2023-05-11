package com.github.kelin.archetype.repository

import com.github.kelin.archetype.KtTestUtils
import com.github.kelin.archetype.TestConstants.USER_DATA
import com.github.kelin.archetype.entity.User
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(USER_DATA)
@Transactional
class UserRepositoryTest : KtTestUtils {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun `find by id`() {
        userRepository.findById(1L) verify {
            get() verify {
                id eq 1
                name eq "test"
            }
        }
    }

    @Test
    fun save() {
        val user = User(name = "test2")
        userRepository.save(user)

        user verify {
            id greater 0
        }
    }
}
