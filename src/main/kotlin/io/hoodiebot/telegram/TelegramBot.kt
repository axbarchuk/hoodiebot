package io.hoodiebot.telegram

import io.hoodiebot.telegram.props.TelegramBotProps
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message


@Component
class TelegramBot(
        val botProps: TelegramBotProps
) : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        return botProps.username
    }

    override fun getBotToken(): String {
        return botProps.token
    }

    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        if (update!!.hasMessage() && update.message.hasText()) {
            val message = SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.message.chatId)
                    .setText(update.message.text)
            try {
                execute<Message, SendMessage>(message) // Call method to send the message
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }
}