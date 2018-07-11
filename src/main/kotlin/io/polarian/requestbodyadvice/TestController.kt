package io.polarian.requestbodyadvice

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CustomRequest
class TestController {
    @PostMapping("/test")
    fun post(@RequestBody request: TestVO): TestVO {
        return request
    }
}

