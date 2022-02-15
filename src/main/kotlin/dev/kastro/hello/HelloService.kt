package dev.kastro.hello

import io.micronaut.context.annotation.Primary
import jakarta.inject.Singleton

@Primary
@Singleton
class HelloService: IHelloService {
    @Override
    override fun helloFromService(): String {
        return "Hello From First Service"
    }
}