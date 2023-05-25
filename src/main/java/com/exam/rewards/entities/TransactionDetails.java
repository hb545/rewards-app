package com.exam.rewards.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * The Class TransactionDetails.
 */
@Entity
@Table(name = "transaction")
@Getter
@Setter
public class TransactionDetails {
    
    /** The id. */
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Id
    @Column(name = "id")
    private Long id;

    /** The customer id. */
    @Column(name = "customerId")
    private String customerId;

    /** The customer name. */
    @Column(name = "customerName")
    private String customerName;

    /** The purchase amount. */
    @Column(name = "purchaseAmount")
    private BigDecimal purchaseAmount;
    
    @Column(name = "purchaseDate")
    private LocalDate purchaseDate;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the purchase amount.
	 *
	 * @return the purchase amount
	 */
	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}

	/**
	 * Sets the purchase amount.
	 *
	 * @param purchaseAmount the new purchase amount
	 */
	public void setPurchaseAmount(BigDecimal purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
    
    
    
}
