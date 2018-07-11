package io.polarian.requestbodyadvice

import io.polarian.requestbodyadvice.CustomHttpInputMessage
import io.polarian.requestbodyadvice.CustomRequest
import org.springframework.core.MethodParameter
import org.springframework.http.HttpInputMessage
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice
import java.lang.reflect.Type


@RestControllerAdvice(annotations = [CustomRequest::class])
class CustomRequestBodyAdvice : RequestBodyAdvice {
    override fun afterBodyRead(body: Any, inputMessage: HttpInputMessage, parameter: MethodParameter, targetType: Type, converterType: Class<out HttpMessageConverter<*>>): Any {
        return body
    }

    override fun beforeBodyRead(inputMessage: HttpInputMessage, parameter: MethodParameter, targetType: Type, converterType: Class<out HttpMessageConverter<*>>): HttpInputMessage {
        var inputMessageAsString = inputMessage.body.bufferedReader().use { it.readText() }
        print(inputMessageAsString)

        // You can change this variable to whatever you want.
        //language=json
        inputMessageAsString = "{\n  \"testString\":\"TTTTTTTTTTTTTTTTTT\",\n  \"testInteger\":11111,\n  \"testList\":[\"A\",\"B\",\"C\"]\n}"

        return CustomHttpInputMessage(inputMessageAsString.byteInputStream(), inputMessage.headers)
    }

    override fun handleEmptyBody(body: Any?, inputMessage: HttpInputMessage, parameter: MethodParameter, targetType: Type, converterType: Class<out HttpMessageConverter<*>>): Any? {
        return body
    }

    override fun supports(methodParameter: MethodParameter, targetType: Type, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return true
    }
}

