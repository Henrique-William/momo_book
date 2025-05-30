package com.momo_tech.momo_book.controllers;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserControler {

    @GetMapping
    public String test() {
        return "Hello, World!";
    }
}
