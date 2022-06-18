package com.primefootball.apigateway.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/app")
class AppController() {

    @GetMapping("/test")
    fun test(principal: Principal): String {
        return principal.name
    }
}