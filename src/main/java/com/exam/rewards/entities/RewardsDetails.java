package com.exam.rewards.entities;

import java.math.BigDecimal;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



/**
 * The Class RewardsDetails.
 */
@Getter
@Setter
@AllArgsConstructor
public class RewardsDetails {
	
	/** The customer id. */
	@Id
	private String customerId;
	
	/** The customer name. */
	private String customerName;
	
	/** The total purchase. */
	private BigDecimal totalPurchase;
	
	/** The rewards. */
	private BigDecimal rewards = new BigDecimal(0);
	
	/** The month. */
	private Object month;
	
	
	/**
	 * Instantiates a new rewards details.
	 *
	 * @param customerId the customer id
	 * @param customerName the customer name
	 * @param totalPurchase the total purchase
	 * @param month the month
	 */
	public RewardsDetails(String customerId, String customerName, BigDecimal totalPurchase, Object month) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalPurchase = totalPurchase;
		this.month=month;
	}

}
