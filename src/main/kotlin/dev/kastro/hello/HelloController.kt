package dev.kastro.hello

import io.micronaut.context.annotation.Property
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject
import org.slf4j.LoggerFactory
import org.slf4j.Logger

@Controller("/hello")
class HelloController(
        @Inject val service: IHelloService,
        @Property(name = "hello.world.message") val helloFromConfig: String,
        private val helloWorldTranslationConfig: HelloWorldTranslationConfig
        ) {
    private val LOG: Logger = LoggerFactory.getLogger(HelloController::class.java)

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun main(): String {
        LOG.debug("Called the hello World API.")
        return service.helloFromService()
    }

    @Get(uri = "/config")
    @Produces(MediaType.TEXT_PLAIN)
    fun helloConfig(): String {
        LOG.debug("Returns Hello From Config Message: $helloFromConfig")
        return helloFromConfig
    }

    @Get(uri = "/translation")
    @Produces(MediaType.APPLICATION_JSON)
    fun helloTranslation(): String {
        val enMessage = helloWorldTranslationConfig.getEn()
        val ptbrMessage = helloWorldTranslationConfig.getPtbr()
        return "en: $enMessage, ptbr: $ptbrMessage"
    }
}