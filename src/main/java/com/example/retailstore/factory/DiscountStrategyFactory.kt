package com.example.retailstore.factory

import com.example.retailstore.model.Bill
import com.example.retailstore.model.UserType.*
import com.example.retailstore.strategy.*
import org.springframework.stereotype.Component

@Component
class DiscountStrategyFactory {
    fun getDiscountStrategy(bill: Bill): DiscountStrategy {
        return if (!bill.isGroceries) {
            when (bill.userType) {
                EMPLOYEE -> EmployeeDiscountStrategy()
                AFFILIATE -> AffiliateDiscountStrategy()
                CUSTOMER_FOR_TWO_YEARS -> CustomerDiscountStrategy()
            }
        } else {
            NoDiscountStrategy()
        }
    }
}