package com.example.retailstore.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
class DiscountControllerTest(@Autowired
                             private val mockMvc: MockMvc) {

    @Test
    @Throws(Exception::class)
    fun shouldReturnNetPayableAmountForUserTypeEmployeeWithGroceries() {
        mockMvc.perform(MockMvcRequestBuilders.post("/net-payable")
                .content("{\"totalAmount\": 200, \"isGroceries\": true, \"userType\":  \"EMPLOYEE\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("{\"netPayableAmount\":200.0}"))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnNetPayableAmountForUserTypeEmployeeWithNoGroceries() {
        mockMvc.perform(MockMvcRequestBuilders.post("/net-payable")
                .content("{\"totalAmount\": 200, \"isGroceries\": false, \"userType\":  \"EMPLOYEE\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("{\"netPayableAmount\":130.0}"))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnNetPayableAmountForUserTypeAffiliate() {
        mockMvc.perform(MockMvcRequestBuilders.post("/net-payable")
                .content("{\"totalAmount\": 500, \"isGroceries\": false, \"userType\":  \"AFFILIATE\"}}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("{\"netPayableAmount\":425.0}"))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnNetPayableAmountForUserTypeCustomerForTwoYears() {
        mockMvc.perform(MockMvcRequestBuilders.post("/net-payable")
                .content("{\"totalAmount\": 500, \"isGroceries\": false, \"userType\":  \"CUSTOMER_FOR_TWO_YEARS\"}}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("{\"netPayableAmount\":450.0}"))
    }
}
