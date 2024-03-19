package edu.upc.blopuptelegrambot

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.math.log
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf

class Bot(botToken: String?) : TelegramLongPollingBot(botToken) {
    private val username = "Blopup_bot"
    private val logger = Logger.getLogger(Bot::class.java.name)

    override fun getBotUsername() = username

    override fun onUpdateReceived(update: Update?) {
        logger.info("Message received: ${update?.message?.text}")
        logger.info("Message sender: ${update?.message?.from?.userName}. Chat id: ${update?.message?.chatId}")

        if (update?.message?.text == "/start") {
            sendMessage(update.message.chatId.toString(), "Hello, I'm Blopup bot! Type / to get a list of available commands.")
        }

        if (update?.message?.isCommand == true) {
            when (update.message.text) {
                "/chatid" ->
                    sendMessage(update.message.chatId.toString(), "your chatId is: ${update.message.chatId}")
            }
        } else {
            sendMessage(update?.message?.chatId.toString(), "Please use commands only! Type / to get a list of available commands")
        }
    }

    private fun sendMessage(chatId: String, text: String) {
        val sendMessage = SendMessage.builder().chatId(chatId).text(text).build()
        try {
            execute(sendMessage)
            logger.info("Message sent: ${sendMessage.text}")
        } catch (e: Exception) {
            logger.log(Level.WARNING, "Error while sending message")
            e.printStackTrace()
        }
    }
}