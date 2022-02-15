package dev.kastro

import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@MicronautTest
class HelloControllerTest {
    @Inject
    @field:Client("/")
    lateinit var client : HttpClient

    @Test
    fun helloWorldEndpointRespondsWithProperContent() {
        val response = client.toBlocking().retrieve("/hello")
        assertEquals("Hello From First Service", response)
    }

    @Test
    fun helloWorldEndpointRespondsWithProperStatusCodeAndContent() {
        val response = client.toBlocking().exchange("/hello", String::class.java)
        assertEquals(HttpStatus.OK, response.status)
        assertEquals("Hello From First Service", response.body.get())
    }
}