package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;
import org.junit.jupiter.api.Test;

import static com.example.retailstore.model.UserType.CUSTOMER_FOR_TWO_YEARS;
import static com.example.retailstore.model.UserType.EMPLOYEE;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerDiscountStrategyTest {
    @Test
    void shouldCalculateNetPayableAmountWithNoGroceries() {
        Bill bill = new Bill(1000, false, CUSTOMER_FOR_TWO_YEARS);

        CustomerDiscountStrategy strategy = new CustomerDiscountStrategy();

        double actual = strategy.calculateNetPayableAmount(bill);

        assertEquals(900, actual);
    }
}