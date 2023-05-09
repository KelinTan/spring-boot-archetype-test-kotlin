package com.github.kelin.archetype

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootArchetypeTestKotlinApplication {
    fun main(args: Array<String>) {
        runApplication<SpringBootArchetypeTestKotlinApplication>(*args)
    }
}
