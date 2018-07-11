package io.polarian.requestbodyadvice

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpInputMessage
import java.io.InputStream

class CustomHttpInputMessage(val inputStream: InputStream, val httpHeaders : HttpHeaders) : HttpInputMessage {
    override fun getHeaders(): HttpHeaders {
        return httpHeaders
    }

    override fun getBody(): InputStream {
        return inputStream
    }

}