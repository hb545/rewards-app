package com.exam.rewards;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.exam.rewards.entities.TransactionDetails;
import com.exam.rewards.repositories.TransactionDetailsRepository;

import jakarta.annotation.PostConstruct;

/**
 * The Class RewardsApplication.
 */
@SpringBootApplication
public class RewardsApplication extends SpringBootServletInitializer {

	/** The transaction details repository. */
	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}

	/**
	 * Adds the rewards data.
	 */
	@PostConstruct
	private void addRewardsData() {
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setCustomerId("1");
		transactionDetails.setCustomerName("Aman");
		transactionDetails.setPurchaseAmount(new BigDecimal("45"));
		transactionDetails.setPurchaseDate(LocalDate.of(2023, 5, 16));

		transactionDetailsRepository.save(transactionDetails);

		TransactionDetails transactionDetails1 = new TransactionDetails();
		transactionDetails1.setCustomerId("1");
		transactionDetails1.setCustomerName("Aman");
		transactionDetails1.setPurchaseAmount(new BigDecimal("65"));
		transactionDetails1.setPurchaseDate(LocalDate.of(2023, 4, 16));

		transactionDetailsRepository.save(transactionDetails1);

		TransactionDetails transactionDetails2 = new TransactionDetails();
		transactionDetails2.setCustomerId("2");
		transactionDetails2.setCustomerName("Pushpa");
		transactionDetails2.setPurchaseAmount(new BigDecimal("79"));
		transactionDetails2.setPurchaseDate(LocalDate.of(2023, 4, 16));

		transactionDetailsRepository.save(transactionDetails2);
	}

}
