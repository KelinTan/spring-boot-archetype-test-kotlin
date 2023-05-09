package com.github.kelin.archetype.mapper

import com.github.kelin.archetype.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

@Mapper
interface UserV2Mapper {
    @Select("SELECT id,name FROM user_v2 WHERE id = #{id}")
    fun getUserById(id: Long?): User?

    @Insert("INSERT INTO user_v2(name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insertUser(user: User)
}
