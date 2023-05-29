package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;
import org.junit.jupiter.api.Test;

import static com.example.retailstore.model.UserType.EMPLOYEE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NoDiscountStrategyTest {
    @Test
    void shouldCalculateNetPayableAmountWithNoGroceries() {
        Bill bill = new Bill(1000, false, EMPLOYEE);

        NoDiscountStrategy strategy = new NoDiscountStrategy();

        double actual = strategy.calculateNetPayableAmount(bill);

        assertEquals(1000, actual);
    }
}