package me.erano.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Postman Authorization header -> Basic Auth -> username: user, password: generated security password
    // Endpoint -> http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Security!";
    }
}
