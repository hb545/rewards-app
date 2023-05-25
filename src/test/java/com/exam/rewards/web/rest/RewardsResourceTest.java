package com.exam.rewards.web.rest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.exam.rewards.entities.RewardsDetails;
import com.exam.rewards.models.Response;
import com.exam.rewards.models.TotalPurchaseCustomerResponse;

/**
 * The Class RewardsResourceTest.
 */
@SpringBootTest
class RewardsResourceTest {
	
	/** The rewards resource. */
	@Autowired
	private RewardsResource rewardsResource;

	/**
	 * Gets the rewards calculated test.
	 *
	 * @return the rewards calculated test
	 */
	@Test
	void getRewardsCalculatedTest() {
		ResponseEntity<Response<List<RewardsDetails>>> rewardsCalculated = rewardsResource.getRewardsCalculated();
		Assertions.assertEquals(rewardsCalculated.getStatusCode(), HttpStatus.OK);
		Assertions.assertEquals(3, rewardsCalculated.getBody().getData().size());
		Assertions.assertEquals("Reward Details Fetched Successfully", rewardsCalculated.getBody().getMessage());
	}
	
	/**
	 * Gets the total purchase amount per user.
	 *
	 * @return the total purchase amount per user
	 */
	@Test
	void getTotalPurchaseAmountPerUser() {
		ResponseEntity<TotalPurchaseCustomerResponse> totalPurchaseAmountPerUser = rewardsResource.getTotalPurchaseAmountPerUser("1");
		Assertions.assertEquals(totalPurchaseAmountPerUser.getStatusCode(), HttpStatus.OK);
		Assertions.assertNotNull(totalPurchaseAmountPerUser.getBody().getTotalPurchaseAmount());
		Assertions.assertEquals("1", totalPurchaseAmountPerUser.getBody().getCustomerId());
	}
	
	/**
	 * Gets the rewards calculated by customer id test.
	 *
	 * @return the rewards calculated by customer id test
	 */
	@Test
	void getRewardsCalculatedByCustomerIdTest() {
		ResponseEntity<Response<List<RewardsDetails>>> rewardsCalculated = rewardsResource.getRewardsCalculatedById("1");
		Assertions.assertEquals(rewardsCalculated.getStatusCode(), HttpStatus.OK);
		Assertions.assertEquals("Reward Details Fetched Successfully", rewardsCalculated.getBody().getMessage());
	}

}
