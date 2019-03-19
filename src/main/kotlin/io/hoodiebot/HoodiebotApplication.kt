package io.hoodiebot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.telegram.telegrambots.ApiContextInitializer

@SpringBootApplication
class HoodiebotApplication

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    runApplication<HoodiebotApplication>(*args)
}
