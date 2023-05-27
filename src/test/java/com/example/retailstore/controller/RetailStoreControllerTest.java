package com.example.retailstore.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RetailStoreControllerTest {
    @Test
    void shouldReturnMessage() {
        RetailStoreController retailStoreController = new RetailStoreController();

        String actual = retailStoreController.getMessage();

        assertEquals("Hello World!", actual);
    }
}