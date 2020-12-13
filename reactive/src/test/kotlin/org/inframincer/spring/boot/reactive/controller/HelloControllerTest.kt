package org.inframincer.spring.boot.reactive.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
class HelloControllerTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun helloTest() {
        webTestClient
            .post().uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .consumeWith {
                assertThat(it.responseBody).isNotNull()
            }
    }

    @Test
    fun helloMonoTest() {
        webTestClient
            .post().uri("/helloMono")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .consumeWith {
                assertThat(it.responseBody).isNotNull()
            }
    }
}
