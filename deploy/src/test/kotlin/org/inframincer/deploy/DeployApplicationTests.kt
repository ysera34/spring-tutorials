package org.inframincer.deploy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DeployApplicationTests {

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    fun contextLoads() {
    }

    @Test
    fun `assert profile`() {
        val profile = restTemplate?.getForObject("/profile", String::class.java)
        profile?.let {
            assertThat(it).isEqualTo("local")
        }
    }
}
