package com.exam.rewards.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TotalPurchaseCustomerResponse {
	
    /** The customer id. */
    private String customerId;
    
    /** The total purchase amount. */
    private BigDecimal totalPurchaseAmount;
}
