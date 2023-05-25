package com.exam.rewards.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.rewards.entities.TransactionDetails;
import com.exam.rewards.models.Response;
import com.exam.rewards.service.TransactionService;



/**
 * The Class TransactionResource.
 */
@RestController
@RequestMapping("/v1/transaction")
public class TransactionResource {
	
	/** The transaction service impl. */
	@Autowired
	private TransactionService transactionServiceImpl;
	
	/**
	 * Gets the all transaction details.
	 *
	 * @return the all transaction details
	 */
	@GetMapping(path = "/get-all-transaction")
	public ResponseEntity<Response<List<TransactionDetails>>> getAllTransactionDetails() {
		Response<List<TransactionDetails>> allTransactionsDetails = transactionServiceImpl.getAllTransactionsDetails();
		if(allTransactionsDetails==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allTransactionsDetails);
	}
	
	/**
	 * Gets the transaction by id.
	 *
	 * @param customerId the customer id
	 * @return the transaction by id
	 */
	@GetMapping(path = "/get-transaction-by-id")
	public ResponseEntity<Response<List<TransactionDetails>>> getTransactionById(@RequestParam String customerId){
		Response<List<TransactionDetails>> allTransactionsDetails = transactionServiceImpl.getTransactionDetailsById(customerId);
		if(allTransactionsDetails==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(allTransactionsDetails);
	}
	
	/**
	 * Save transaction detail.
	 *
	 * @param tarDetails the tar details
	 * @return the response entity
	 */
	@PostMapping(path = "/save-transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionDetails>> saveTransactionDetail(@RequestBody List<TransactionDetails> tarDetails){
		return new ResponseEntity<>(transactionServiceImpl.saveTransactions(tarDetails), HttpStatus.CREATED);
	}

}
