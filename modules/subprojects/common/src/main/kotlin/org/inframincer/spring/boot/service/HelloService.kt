package org.inframincer.spring.boot.service

import org.springframework.stereotype.Service

@Service
class HelloService {
    fun hello(): String {
        return "hello service"
    }
}
