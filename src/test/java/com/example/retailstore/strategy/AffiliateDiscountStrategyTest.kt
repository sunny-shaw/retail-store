package com.example.retailstore.strategy

import com.example.retailstore.model.Bill
import com.example.retailstore.model.UserType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


internal class AffiliateDiscountStrategyTest {
    @Test
    fun shouldCalculateNetPayableAmountWithNoGroceries() {
        val bill = Bill(1000.0, false, UserType.AFFILIATE)
        val strategy = AffiliateDiscountStrategy()

        val actual = strategy.calculateNetPayableAmount(bill)

        assertEquals(850.0, actual)
    }
}