package org.inframincer.spring.boot.starter

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

@SpringBootApplication
class StarterApplication {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun commandLineRunner(context: ApplicationContext): CommandLineRunner {
        return CommandLineRunner {
            logger.info("Let's inspect the beans provided by Spring Boot:")

            context.beanDefinitionNames.sorted().forEach {
                logger.info("ApplicationContext BeanDefinitionName :: {}", it)
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<StarterApplication>(*args)
}
