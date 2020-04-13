package org.inframincer.spring.boot.starter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import java.net.URL
import kotlin.random.Random

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @Autowired
    lateinit var template: TestRestTemplate

    @LocalServerPort
    private val port = Random.nextInt(0, 65535)

    lateinit var baseUrl: URL

    @BeforeEach
    fun setUp() {
        baseUrl = URL("http://localhost:$port")
        template = TestRestTemplate()
    }

    @Test
    fun testGetHello() {
        val response = template.getForEntity("$baseUrl/GetHello", String::class.java)
        assertThat(response.body).isEqualTo("Greetings from Spring Boot!")
    }
}
