package org.inframincer.deploy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DeployApplication

fun main(args: Array<String>) {
	runApplication<DeployApplication>(*args)
}
