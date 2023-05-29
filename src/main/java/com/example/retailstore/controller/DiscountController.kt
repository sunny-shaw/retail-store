package com.example.retailstore.controller

import com.example.retailstore.factory.DiscountStrategyFactory
import com.example.retailstore.model.Bill
import com.example.retailstore.model.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.lang.NonNull
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class DiscountController(@Autowired private val discountStrategyFactory: DiscountStrategyFactory) {

    @PostMapping("/net-payable")
    fun calculateNetPayableAmount(@NonNull @RequestBody bill: Bill): ResponseEntity<Response> {
        val discountStrategy = discountStrategyFactory.getDiscountStrategy(bill)

        return ResponseEntity.ok(Response(discountStrategy.calculateNetPayableAmount(bill)))
    }
}
