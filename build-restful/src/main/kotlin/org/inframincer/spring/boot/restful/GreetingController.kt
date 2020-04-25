package org.inframincer.spring.boot.restful

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val template = "hello, %s!"
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun getGreeting(@RequestParam(value = "name", defaultValue = "world") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }
}
