package org.inframincer.deploy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DeployApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun contextLoads() {
    }

    @Test
    fun `assert profile`() {
        val profile = restTemplate.getForObject("/profile", String::class.java)
        assertThat(profile).isEqualTo("local")
    }
}
