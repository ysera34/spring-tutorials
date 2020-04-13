package org.inframincer.spring.boot.starter

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController // combines @Controller and @ResponseBody
class HelloController {

    @RequestMapping("/GetHello")
    fun getHello(): String {
        return "Greetings from Spring Boot!"
    }
}
