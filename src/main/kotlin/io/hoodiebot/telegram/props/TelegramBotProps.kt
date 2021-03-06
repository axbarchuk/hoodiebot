package io.hoodiebot.telegram.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "telegram.bot")
class TelegramBotProps {
    lateinit var username: String
    lateinit var token: String
}