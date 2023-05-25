package com.exam.rewards.service;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exam.rewards.entities.RewardsDetails;
import com.exam.rewards.repositories.TransactionDetailsRepository;
import com.exam.rewards.service.impl.RewardsServiceImpl;


/**
 * The Class RewardsServiceImplTest.
 */
@ExtendWith(MockitoExtension.class)
class RewardsServiceImplTest {
	
	/** The rewards service. */
	@InjectMocks
	private RewardsServiceImpl rewardsService;
	
	/** The transaction details repository. */
	@Mock
	private TransactionDetailsRepository transactionDetailsRepository;

	/**
	 * Gets the all customer with rewards test.
	 *
	 * @return the all customer with rewards test
	 */
	@Test
	void getAllCustomerWithRewardsTest() {
		Mockito.when(transactionDetailsRepository.getAllCustomersWithRewards(Mockito.any())).thenReturn(getTransactionDetails());
		Assertions.assertEquals(rewardsService.getTotalRewards().getData().get(0).getRewards(), new BigDecimal(29));
	}
	
	/**
	 * Gets the customer with rewards by id test.
	 *
	 * @return the customer with rewards by id test
	 */
	@Test
	void getCustomerWithRewardsByIdTest() {
		Mockito.when(transactionDetailsRepository.getRewardByCustomerId(Mockito.anyString(), Mockito.any())).thenReturn(getTransactionDetails());
		Assertions.assertEquals(rewardsService.getTotalRewardsId("1").getData().get(0).getRewards(), new BigDecimal(29));
	}

	/**
	 * Gets the transaction details.
	 *
	 * @return the transaction details
	 */
	private List<RewardsDetails> getTransactionDetails() {
		RewardsDetails rewardsDetails = new RewardsDetails("1", "Aman", new BigDecimal(79), "3");
		return List.of(rewardsDetails);
	}

	

}
