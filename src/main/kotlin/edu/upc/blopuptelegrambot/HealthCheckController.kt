package edu.upc.blopuptelegrambot

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/**", "/")
    fun forwardToHealth(): ResponseEntity<String> = ResponseEntity.status(301).location(java.net.URI("/health")).build()

    @GetMapping("/health")
    fun healthCheck() = "I'm alive and well!"
}