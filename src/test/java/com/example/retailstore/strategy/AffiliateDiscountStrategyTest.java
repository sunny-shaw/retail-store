package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;
import org.junit.jupiter.api.Test;

import static com.example.retailstore.model.UserType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AffiliateDiscountStrategyTest {
    @Test
    void shouldCalculateNetPayableAmountWithNoGroceries() {
        Bill bill = new Bill(1000, false, AFFILIATE);

        AffiliateDiscountStrategy strategy = new AffiliateDiscountStrategy();

        double actual = strategy.calculateNetPayableAmount(bill);

        assertEquals(850, actual);
    }
}