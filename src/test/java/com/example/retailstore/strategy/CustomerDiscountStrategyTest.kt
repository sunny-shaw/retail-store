package com.example.retailstore.strategy

import com.example.retailstore.model.Bill
import com.example.retailstore.model.UserType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


internal class CustomerDiscountStrategyTest {
    @Test
    fun shouldCalculateNetPayableAmountWithNoGroceries() {
        val bill = Bill(1000.0, false, UserType.CUSTOMER_FOR_TWO_YEARS)
        val strategy = CustomerDiscountStrategy()
        val actual = strategy.calculateNetPayableAmount(bill)
        Assertions.assertEquals(900.0, actual)
    }
}