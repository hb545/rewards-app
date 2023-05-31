package com.exam.rewards.web.rest;

import java.math.BigDecimal;
import java.util.List;

import com.exam.rewards.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.exam.rewards.entities.TransactionDetails;
import com.exam.rewards.models.Response;


/**
 * The Class TransactionResourceTest.
 */
@SpringBootTest
class TransactionControllerTest {

	/** The transaction resource. */
	@Autowired
	private TransactionController transactionController;

	/**
	 * Gets the all transaction details test.
	 *
	 * @return the all transaction details test
	 */
	@Test
	void getAllTransactionDetailsTest() {
		ResponseEntity<Response<List<TransactionDetails>>> allTransactionDetails = transactionController
				.getAllTransactionDetails();
		Assertions.assertEquals(HttpStatus.OK, allTransactionDetails.getStatusCode());
		Assertions.assertEquals(3, allTransactionDetails.getBody().getData().size());
	}

	/**
	 * Gets the all transaction details by id test.
	 *
	 * @return the all transaction details by id test
	 */
	@Test
	void getAllTransactionDetailsByIdTest() {
		ResponseEntity<Response<List<TransactionDetails>>> allTransactionDetails = transactionController
				.getTransactionById("1");
		Assertions.assertEquals(HttpStatus.OK, allTransactionDetails.getStatusCode());
		Assertions.assertEquals(2, allTransactionDetails.getBody().getData().size());
	}

	@Test
	void getAllTransactionDetailsByIdNotFoundTest() {
		try {
			transactionController
					.getTransactionById("4");
		}catch(NotFoundException ex) {
			Assertions.assertEquals("Customer Id not found", ex.getText());
		}
	}

	/**
	 * Save transaction test.
	 */
	@Test
	void saveTransactionTest() {

		ResponseEntity<List<TransactionDetails>> allTransactionDetails = transactionController
				.saveTransactionDetail(createTransactionDetailsList());
		Assertions.assertEquals(HttpStatus.CREATED, allTransactionDetails.getStatusCode());
		Assertions.assertEquals(1, allTransactionDetails.getBody().size());
	}

	/**
	 * Creates the transaction details list.
	 *
	 * @return the list
	 */
	private List<TransactionDetails> createTransactionDetailsList() {
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setCustomerId("1");
		transactionDetails.setCustomerName("Aman");
		transactionDetails.setPurchaseAmount(new BigDecimal("39"));

		return List.of(transactionDetails);
	}
}
