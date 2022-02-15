package dev.kastro.hello

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/hello")
class HelloController {
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun main(): String {
        return "Hello World"
    }
}