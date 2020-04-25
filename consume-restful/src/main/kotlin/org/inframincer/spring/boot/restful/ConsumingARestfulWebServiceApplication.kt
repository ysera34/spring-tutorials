package org.inframincer.spring.boot.restful

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class ConsumingARestfulWebServiceApplication {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate? {
        return restTemplateBuilder.build()
    }

    @Bean
    fun run(restTemplate: RestTemplate): CommandLineRunner {
        return CommandLineRunner {
            val quote = restTemplate.getForObject(
                "https://gturnquist-quoters.cfapps.io/api/random",
                Quote::class.java
            )
            logger.info("Quote :: {}", quote)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ConsumingARestfulWebServiceApplication>(*args)
}
