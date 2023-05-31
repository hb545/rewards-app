package com.exam.rewards.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exam.rewards.entities.RewardsDetails;
import com.exam.rewards.models.Response;
import com.exam.rewards.models.TotalPurchaseCustomerResponse;
import com.exam.rewards.service.RewardsService;


/**
 * The Class RewardsResource.
 */
@RestController
@RequestMapping("/v1/rewards")
public class RewardsController {
	
	/** The rewards service. */
	@Autowired
	private RewardsService rewardsService;
	
	/**
	 * Gets the total purchase amount per user.
	 *
	 * @param customerId the customer id
	 * @return the total purchase amount per user
	 */
	@GetMapping(path = "/get-total-purchase-by-id/{customerId}")
	public ResponseEntity<TotalPurchaseCustomerResponse> getTotalPurchaseAmountPerUser(@PathVariable String customerId) {
		TotalPurchaseCustomerResponse response = rewardsService.getTotalPurchasePerId(customerId);
		if(response==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Gets the rewards calculated.
	 *
	 * @return the rewards calculated
	 */
	@GetMapping(path="/get-rewards")
	public ResponseEntity<Response<List<RewardsDetails>>> getRewardsCalculated() {
		return ResponseEntity.ok(rewardsService.getTotalRewards());
	}
	
	/**
	 * Gets the rewards calculated.
	 *
	 * @param customerId the customer id
	 * @return the rewards calculated
	 */
	@GetMapping(path="/get-rewards-by-customer-id/{customerId}")
	public ResponseEntity<Response<List<RewardsDetails>>> getRewardsCalculatedById(@PathVariable String customerId) {
		Response<List<RewardsDetails>> response = rewardsService.getTotalRewardsId(customerId);
		if(response==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(response);
	}
}
