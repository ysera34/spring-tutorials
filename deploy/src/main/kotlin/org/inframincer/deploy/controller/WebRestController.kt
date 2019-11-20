package org.inframincer.deploy.controller

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class WebRestController(
    private val environment: Environment
) {
    @GetMapping("/profile")
    fun getProfile(): String {
        return Arrays.stream(environment.activeProfiles)
            .findFirst()
            .orElse("")
    }
}