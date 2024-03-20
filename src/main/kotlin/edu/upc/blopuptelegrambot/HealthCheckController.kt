package edu.upc.blopuptelegrambot

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/**", "/")
    fun forwardToHealth() = "Greetings from Blopup Telegram Blot! I'm alive and well!"
}