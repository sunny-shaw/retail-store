package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;

public interface DiscountStrategy {
    double DISCOUNT_PER_100 = 5.0;

    double calculateNetPayableAmount(Bill bill);
}
