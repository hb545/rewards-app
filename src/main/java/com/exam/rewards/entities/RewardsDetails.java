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


	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}


	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	/**
	 * Gets the customer name.
	 *
	 * @return the customer name
	 */
	public String getCustomerName() {
		return customerName;
	}


	/**
	 * Sets the customer name.
	 *
	 * @param customerName the new customer name
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	/**
	 * Gets the total purchase.
	 *
	 * @return the total purchase
	 */
	public BigDecimal getTotalPurchase() {
		return totalPurchase;
	}


	/**
	 * Sets the total purchase.
	 *
	 * @param totalPurchase the new total purchase
	 */
	public void setTotalPurchase(BigDecimal totalPurchase) {
		this.totalPurchase = totalPurchase;
	}


	/**
	 * Gets the rewards.
	 *
	 * @return the rewards
	 */
	public BigDecimal getRewards() {
		return rewards;
	}


	/**
	 * Sets the rewards.
	 *
	 * @param rewards the new rewards
	 */
	public void setRewards(BigDecimal rewards) {
		this.rewards = rewards;
	}
	
	

}
