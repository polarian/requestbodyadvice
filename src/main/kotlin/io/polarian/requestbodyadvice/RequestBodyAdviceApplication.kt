package io.polarian.requestbodyadvice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RequestBodyAdviceApplication

fun main(args: Array<String>) {
    runApplication<RequestBodyAdviceApplication>(*args)
}
