package com.exam.rewards.service;

import com.exam.rewards.entities.TransactionDetails;
import com.exam.rewards.models.Response;

import java.util.List;

/**
 * The Interface TransactionService.
 */
public interface TransactionService {
    
    /**
     * Gets the all transactions details.
     *
     * @return the all transactions details
     */
    public Response<List<TransactionDetails>> getAllTransactionsDetails();
    
    /**
     * Gets the transaction details by id.
     *
     * @param customerId the customer id
     * @return the transaction details by id
     */
    public Response<List<TransactionDetails>> getTransactionDetailsById(String customerId);
    
    /**
     * Save transactions.
     *
     * @param tarDetails the tar details
     * @return the list
     */
    public List<TransactionDetails> saveTransactions(List<TransactionDetails> tarDetails);
}
