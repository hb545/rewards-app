package com.exam.rewards.service;

import com.exam.rewards.entities.TransactionDetails;
import com.exam.rewards.models.Response;
import com.exam.rewards.repositories.TransactionDetailsRepository;
import com.exam.rewards.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

/**
 * The Class TransactionServiceImplTest.
 */
@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

    /** The transaction service. */
    @InjectMocks
    private TransactionServiceImpl transactionService;

    /** The transaction details repository. */
    @Mock
    private TransactionDetailsRepository transactionDetailsRepository;

    /**
     * Gets the all transaction details test.
     *
     * @return the all transaction details test
     */
    @Test
    void getAllTransactionDetailsTest(){
        Mockito.when(transactionDetailsRepository.findAll()).thenReturn(createTransactionDetailsList());
        Response<List<TransactionDetails>> allTransactionsDetails = transactionService.getAllTransactionsDetails();
        Assertions.assertEquals(allTransactionsDetails.getData().size(), 1);
        Assertions.assertEquals(allTransactionsDetails.getMessage(), "Transaction Details Fetched Successfully");
    }

    /**
     * Gets the transaction details test.
     *
     * @return the transaction details test
     */
    @Test
    void getTransactionDetailsTest(){
        Mockito.when(transactionDetailsRepository.findByCustomerId(Mockito.anyString())).thenReturn(createTransactionDetailsList());
        Response<List<TransactionDetails>> transactionDetailsById = transactionService.getTransactionDetailsById("1");
        Assertions.assertEquals(transactionDetailsById.getData().size(), 1);
        Assertions.assertEquals(transactionDetailsById.getMessage(), "Transaction Details Fetched Successfully");
    }
    
    /**
     * Creates the transaction details list.
     *
     * @return the list
     */
    private List<TransactionDetails> createTransactionDetailsList(){
        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setCustomerId("1");
        transactionDetails.setCustomerName("Aman");
        transactionDetails.setPurchaseAmount(new BigDecimal("45"));

        return List.of(transactionDetails);
    }
}
