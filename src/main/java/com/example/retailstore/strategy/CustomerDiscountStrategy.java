package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;
import org.springframework.stereotype.Component;

@Component
public class CustomerDiscountStrategy implements DiscountStrategy {
    private static final double CUSTOMER_DISCOUNT = 0.05;

    @Override
    public double calculateNetPayableAmount(Bill bill) {
        double totalAmount = bill.getTotalAmount();
        double netPayableAmount = totalAmount;

        netPayableAmount -= totalAmount * CUSTOMER_DISCOUNT;

        double discountAmount = (int) (totalAmount / 100) * DISCOUNT_PER_100;
        netPayableAmount -= discountAmount;

        return netPayableAmount;
    }
}