package com.example.retailstore.strategy

import com.example.retailstore.model.Bill
import org.springframework.stereotype.Component


@Component
class CustomerDiscountStrategy : DiscountStrategy {
    override fun calculateNetPayableAmount(bill: Bill): Double {
        val totalAmount = bill.totalAmount
        var netPayableAmount = totalAmount
        netPayableAmount -= totalAmount * CUSTOMER_DISCOUNT

        val discountAmount = (totalAmount / 100).toInt() * DiscountStrategy.DISCOUNT_PER_100
        netPayableAmount -= discountAmount

        return netPayableAmount
    }

    companion object {
        private const val CUSTOMER_DISCOUNT = 0.05
    }
}