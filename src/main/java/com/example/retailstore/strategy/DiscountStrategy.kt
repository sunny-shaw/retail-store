package com.example.retailstore.strategy

import com.example.retailstore.model.Bill


interface DiscountStrategy {
    fun calculateNetPayableAmount(bill: Bill): Double

    companion object {
        const val DISCOUNT_PER_100 = 5.0
    }
}
