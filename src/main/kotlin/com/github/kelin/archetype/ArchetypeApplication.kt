package com.github.kelin.archetype

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArchetypeApplication {
    fun main(args: Array<String>) {
        runApplication<ArchetypeApplication>(*args)
    }
}
