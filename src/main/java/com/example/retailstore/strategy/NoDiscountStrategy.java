package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;
import org.springframework.stereotype.Component;

@Component
public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculateNetPayableAmount(Bill bill) {
        return bill.getTotalAmount();
    }
}