package dev.kastro.hello

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject

@Controller("/hello")
class HelloController(@Inject val service: IHelloService) {
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun main(): String {
        return service.helloFromService()
    }
}