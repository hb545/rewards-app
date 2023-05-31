package com.exam.rewards.service.impl;

import java.util.List;

import com.exam.rewards.exceptions.NotFoundException;
import com.exam.rewards.models.Response;
import com.exam.rewards.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.rewards.entities.TransactionDetails;
import com.exam.rewards.repositories.TransactionDetailsRepository;

/**
 * The Class TransactionServiceImpl.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	/** The Constant TRANSACTION_DETAILS_FETCHED_SUCCESSFULLY. */
	public static final String TRANSACTION_DETAILS_FETCHED_SUCCESSFULLY = "Transaction Details Fetched Successfully";
	/** The transaction details repository. */
	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;
	
	/**
	 * Gets the all transactions details.
	 *
	 * @return the all transactions details
	 */
	public Response<List<TransactionDetails>> getAllTransactionsDetails(){
		Response<List<TransactionDetails>> response = null;
		List<TransactionDetails> transactionDetailsList = transactionDetailsRepository.findAll();
		if(transactionDetailsList.isEmpty()){
			throw new NotFoundException("No data found.");
		}
		if(transactionDetailsList!=null){
			response = new Response<>();
			response.setMessage(TRANSACTION_DETAILS_FETCHED_SUCCESSFULLY);
			response.setData(transactionDetailsList);
		}
		return response;
	}
	
	/**
	 * Gets the transaction details by id.
	 *
	 * @param customerId the customer id
	 * @return the transaction details by id
	 */
	public Response<List<TransactionDetails>> getTransactionDetailsById(String customerId){
		Response<List<TransactionDetails>> response=null;
		List<TransactionDetails> transactionsList = transactionDetailsRepository.findByCustomerId(customerId);
		if(transactionsList.isEmpty()){
			throw new NotFoundException("Customer Id not found");
		}
		if(transactionsList!=null){
			response = new Response<>();
			response.setMessage(TRANSACTION_DETAILS_FETCHED_SUCCESSFULLY);
			response.setData(transactionsList);
		}
		return response;
	}

	/**
	 * Save transactions.
	 *
	 * @param tarDetails the tar details
	 * @return the list
	 */
	public List<TransactionDetails> saveTransactions(List<TransactionDetails> tarDetails) {
		return transactionDetailsRepository.saveAll(tarDetails);	
	}

}
