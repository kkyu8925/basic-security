package io.security.basicsecurity

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecurityController {

    @GetMapping("/")
    fun index(): String {
        return "home"
    }

    @GetMapping("/user")
    fun user(): String {
        return "user"
    }

    @GetMapping("/admin/sys")
    fun sys(): String {
        return "sys"
    }

    @GetMapping("/admin/test")
    fun admin(): String {
        return "admin"
    }
}
