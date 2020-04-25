package org.inframincer.spring.boot.restful

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsumingARestfulWebServiceApplication

fun main(args: Array<String>) {
	runApplication<ConsumingARestfulWebServiceApplication>(*args)
}
