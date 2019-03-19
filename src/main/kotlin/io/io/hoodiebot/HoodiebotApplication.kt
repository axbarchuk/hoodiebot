package io.io.hoodiebot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoodiebotApplication

fun main(args: Array<String>) {
    runApplication<HoodiebotApplication>(*args)
}
