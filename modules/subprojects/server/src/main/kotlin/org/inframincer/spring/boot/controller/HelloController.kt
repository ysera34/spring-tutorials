package org.inframincer.spring.boot.controller

import org.inframincer.spring.boot.service.HelloService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService
) {
    @RequestMapping("/hello")
    fun hello(): String {
        return helloService.hello()
    }
}
