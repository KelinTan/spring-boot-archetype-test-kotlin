package com.github.kelin.archetype.repository

import com.github.kelin.archetype.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
