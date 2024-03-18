package edu.upc.blopuptelegrambot

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

class BotTest {

    @Test
    fun shouldSendMessageWithChatId() {
        val bot = Bot("123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11")
        val chatId = "123456"

        val sendMessage = mockk<SendMessage>()

        verify(exactly = 1) { bot.execute(sendMessage) }
    }
}