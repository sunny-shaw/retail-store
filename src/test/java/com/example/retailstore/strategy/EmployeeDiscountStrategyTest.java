package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;
import org.junit.jupiter.api.Test;

import static com.example.retailstore.model.UserType.AFFILIATE;
import static com.example.retailstore.model.UserType.EMPLOYEE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeDiscountStrategyTest {
    @Test
    void shouldCalculateNetPayableAmountWithNoGroceries() {
        Bill bill = new Bill(1000, false, EMPLOYEE);

        EmployeeDiscountStrategy strategy = new EmployeeDiscountStrategy();

        double actual = strategy.calculateNetPayableAmount(bill);

        assertEquals(650, actual);
    }
}