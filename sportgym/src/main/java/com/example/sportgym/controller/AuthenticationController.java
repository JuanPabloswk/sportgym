package com.example.sportgym.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class AuthenticationController {

    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello-secured")
    @PreAuthorize("hasAnyAuthority('READ')")
    public String helloSecured() {
        return "Hello World secured";
    }

    @GetMapping("/hello-secured2")
    @PreAuthorize("hasAnyAuthority('CREATE')")
    public String helloSecured2() {
        return "Hello World secured";
    }

}
