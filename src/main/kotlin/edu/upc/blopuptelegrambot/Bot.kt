package edu.upc.blopuptelegrambot

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class Bot(botToken: String?) : TelegramLongPollingBot(botToken) {
    private val username = "Blopup_bot"
    private var lastMessage: SendMessage? = null

    override fun getBotUsername() = username

    override fun onUpdateReceived(update: Update?) {
        println(update?.message?.text)
        println(update?.message?.chatId)

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
            lastMessage = sendMessage
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}