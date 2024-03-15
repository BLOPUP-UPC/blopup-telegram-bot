package upc.edu.blopuptelegrambot

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@SpringBootApplication
class BlopupTelegramApplication



fun main() {
        val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
    val bot = Bot(System.getenv("TELEGRAM_BOT_TOKEN"))
    botsApi.registerBot(bot)

    }