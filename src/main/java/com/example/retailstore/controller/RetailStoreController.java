package com.example.retailstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetailStoreController {
    @GetMapping("hello")
    public String getMessage() {
        return "Hello World!";
    }
}
