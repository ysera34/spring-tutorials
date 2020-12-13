package org.inframincer.spring.boot.reactive.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HelloController {

    @RequestMapping("/hello")
    fun hello(): String {
        return "Hello World"
    }

    @RequestMapping("/helloMono")
    fun helloMono(): Mono<String> {
        return Mono.just("Hello World Mono")
    }
}
