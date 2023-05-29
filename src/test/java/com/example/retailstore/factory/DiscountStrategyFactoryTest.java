package com.example.retailstore.factory;

import com.example.retailstore.model.Bill;
import com.example.retailstore.strategy.*;
import org.junit.jupiter.api.Test;

import static com.example.retailstore.model.UserType.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountStrategyFactoryTest {

    private final DiscountStrategyFactory factory  = new DiscountStrategyFactory();


    @Test
    public void shouldReturnsEmployeeDiscountStrategy() {
        Bill bill = new Bill(1000, false, EMPLOYEE);

        DiscountStrategy strategy = factory.getDiscountStrategy(bill);

        assertTrue(strategy instanceof EmployeeDiscountStrategy);
    }

    @Test
    public void shouldReturnsAffiliateDiscountStrategy() {
        Bill bill = new Bill(1000, false, AFFILIATE);

        DiscountStrategy strategy = factory.getDiscountStrategy(bill);

        assertTrue(strategy instanceof AffiliateDiscountStrategy);
    }

    @Test
    public void shouldReturnsCustomerDiscountStrategy() {
        Bill bill = new Bill(1000, false, CUSTOMER_FOR_TWO_YEARS);

        DiscountStrategy strategy = factory.getDiscountStrategy(bill);

        assertTrue(strategy instanceof CustomerDiscountStrategy);
    }

    @Test
    public void shouldReturnsNoDiscountStrategy() {
        Bill bill = new Bill(1000, true, CUSTOMER_FOR_TWO_YEARS);

        DiscountStrategy strategy = factory.getDiscountStrategy(bill);

        assertTrue(strategy instanceof NoDiscountStrategy);
    }
}
