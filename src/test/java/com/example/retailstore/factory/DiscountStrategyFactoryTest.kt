package com.example.retailstore.factory

import com.example.retailstore.model.Bill
import com.example.retailstore.model.UserType
import com.example.retailstore.strategy.AffiliateDiscountStrategy
import com.example.retailstore.strategy.CustomerDiscountStrategy
import com.example.retailstore.strategy.EmployeeDiscountStrategy
import com.example.retailstore.strategy.NoDiscountStrategy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class DiscountStrategyFactoryTest {
    private val factory = DiscountStrategyFactory()
    @Test
    fun shouldReturnsEmployeeDiscountStrategy() {
        val bill = Bill(1000.0, false, UserType.EMPLOYEE)

        val strategy = factory.getDiscountStrategy(bill)

        assertTrue(strategy is EmployeeDiscountStrategy)
    }

    @Test
    fun shouldReturnsAffiliateDiscountStrategy() {
        val bill = Bill(1000.0, false, UserType.AFFILIATE)

        val strategy = factory.getDiscountStrategy(bill)

        assertTrue(strategy is AffiliateDiscountStrategy)
    }

    @Test
    fun shouldReturnsCustomerDiscountStrategy() {
        val bill = Bill(1000.0, false, UserType.CUSTOMER_FOR_TWO_YEARS)

        val strategy = factory.getDiscountStrategy(bill)

        assertTrue(strategy is CustomerDiscountStrategy)
    }

    @Test
    fun shouldReturnsNoDiscountStrategy() {
        val bill = Bill(1000.0, true, UserType.CUSTOMER_FOR_TWO_YEARS)

        val strategy = factory.getDiscountStrategy(bill)

        assertTrue(strategy is NoDiscountStrategy)
    }
}
