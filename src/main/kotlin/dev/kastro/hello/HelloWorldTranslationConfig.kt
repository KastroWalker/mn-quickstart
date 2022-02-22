package dev.kastro.hello

import io.micronaut.context.annotation.ConfigurationProperties
import javax.validation.constraints.NotBlank

@ConfigurationProperties("hello.world.translation")
interface HelloWorldTranslationConfig {
    @NotBlank
    fun getPtbr(): String

    @NotBlank
    fun getEn(): String
}