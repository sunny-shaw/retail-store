package com.example.retailstore.strategy

import com.example.retailstore.model.Bill
import com.example.retailstore.model.UserType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


internal class EmployeeDiscountStrategyTest {
    @Test
    fun shouldCalculateNetPayableAmountWithNoGroceries() {
        val bill = Bill(1000.0, false, UserType.EMPLOYEE)
        val strategy = EmployeeDiscountStrategy()

        val actual = strategy.calculateNetPayableAmount(bill)

        assertEquals(650.0, actual)
    }
}