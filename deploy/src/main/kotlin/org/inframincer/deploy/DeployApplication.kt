package org.inframincer.deploy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class DeployApplication

const val APPLICATION_LOCATIONS = "spring.config.location=" +
    "classpath:application.yaml," +
    "classpath:config/application.yaml"

fun main(args: Array<String>) {
    SpringApplicationBuilder(DeployApplication::class.java)
        .properties(APPLICATION_LOCATIONS)
        .run(*args)
}
