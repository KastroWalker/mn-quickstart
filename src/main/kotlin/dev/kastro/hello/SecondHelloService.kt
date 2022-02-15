package dev.kastro.hello

import jakarta.inject.Singleton

@Singleton
class SecondHelloService: IHelloService {
    @Override
    override fun helloFromService(): String {
        return "Hello From Second Service"
    }
}