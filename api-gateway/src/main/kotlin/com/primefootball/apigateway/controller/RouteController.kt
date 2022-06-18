package com.primefootball.apigateway.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class RouteController {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello gateway!!!"
    }
}
