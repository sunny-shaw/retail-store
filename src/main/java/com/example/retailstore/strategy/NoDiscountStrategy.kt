package com.example.retailstore.strategy

import com.example.retailstore.model.Bill
import org.springframework.stereotype.Component


@Component
class NoDiscountStrategy : DiscountStrategy {
    override fun calculateNetPayableAmount(bill: Bill): Double {
        return bill.totalAmount
    }
}