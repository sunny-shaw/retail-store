package com.example.retailstore.strategy;

import com.example.retailstore.model.Bill;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDiscountStrategy implements DiscountStrategy {
    private static final double EMPLOYEE_DISCOUNT = 0.3;

    @Override
    public double calculateNetPayableAmount(Bill bill) {
        double totalAmount = bill.getTotalAmount();
        double netPayableAmount = totalAmount;

        netPayableAmount -= totalAmount * EMPLOYEE_DISCOUNT;

        double discountAmount = (int) (totalAmount / 100) * DISCOUNT_PER_100;
        netPayableAmount -= discountAmount;

        return netPayableAmount;
    }
}