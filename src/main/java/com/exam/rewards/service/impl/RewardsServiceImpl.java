package com.exam.rewards.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.exam.rewards.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.rewards.entities.RewardsDetails;
import com.exam.rewards.models.Response;
import com.exam.rewards.models.TotalPurchaseCustomerResponse;
import com.exam.rewards.repositories.TransactionDetailsRepository;
import com.exam.rewards.service.RewardsService;


/**
 * The Class RewardsServiceImpl.
 */
@Service
public class RewardsServiceImpl implements RewardsService {

	/** The Constant TWO. */
	private static final int TWO = 2;
	
	/** The Constant ZERO. */
	private static final int ZERO = 0;
	
	/** The Constant FIFTY. */
	private static final int FIFTY = 50;
	
	/** The Constant HUNDRED. */
	private static final int HUNDRED = 100;
	
	/** The Constant REWARD_DETAILS_FETCHED_SUCCESSFULLY. */
	private static final String REWARD_DETAILS_FETCHED_SUCCESSFULLY = "Reward Details Fetched Successfully";
	
	/** The transaction details repository. */
	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;

	/**
	 * Gets the total purchase per id.
	 *
	 * @param customerId the customer id
	 * @return the total purchase per id
	 */
	public TotalPurchaseCustomerResponse getTotalPurchasePerId(String customerId) {
		TotalPurchaseCustomerResponse response = null;
		BigDecimal totalPurchaseSum = transactionDetailsRepository.getSumOfRewardsById(customerId);
		if(totalPurchaseSum!=null){
			response = new TotalPurchaseCustomerResponse();
			response.setCustomerId(customerId);
			response.setTotalPurchaseAmount(totalPurchaseSum);
		}else{
			throw new NotFoundException("Customer Id not found");
		}
		return response;
	}

	/**
	 * Gets the total rewards.
	 *
	 * @return the total rewards
	 */
	public Response<List<RewardsDetails>> getTotalRewards() {
		LocalDate dateBeforeThreeMonths = LocalDate.now().minusMonths(3);
		List<RewardsDetails> allCustomersWithRewards = transactionDetailsRepository.getAllCustomersWithRewards(dateBeforeThreeMonths);
		allCustomersWithRewards.forEach(x -> {
			Integer reward = calculateRewards(x);
			x.setRewards(new BigDecimal(reward));
		});

		Response<List<RewardsDetails>> response = new Response<>();
		response.setMessage(REWARD_DETAILS_FETCHED_SUCCESSFULLY);
		response.setData(allCustomersWithRewards);
		return response;
	}

	/**
	 * Calculate rewards.
	 *
	 * @param x the x
	 * @return the integer
	 */
	private Integer calculateRewards(RewardsDetails x) {
		x.setMonth(Month.of(Integer.parseInt(String.valueOf(x.getMonth()))).name());
		Integer reward = ZERO;
		if (x.getTotalPurchase().compareTo(new BigDecimal(FIFTY)) > ZERO) {
			if (x.getTotalPurchase().compareTo(new BigDecimal(HUNDRED)) > ZERO) {
				reward = FIFTY + (x.getTotalPurchase().intValue() - HUNDRED) * TWO;
			} else {
				reward = (x.getTotalPurchase().intValue() - FIFTY);
			}
		}
		return reward;
	}

	/**
	 * Gets the total rewards id.
	 *
	 * @param customerId the customer id
	 * @return the total rewards id
	 */
	public Response<List<RewardsDetails>> getTotalRewardsId(String customerId) {
		Response<List<RewardsDetails>> response = null;
		LocalDate dateBeforeThreeMonths = LocalDate.now().minusMonths(3);
		List<RewardsDetails> rewardByCustomerId = transactionDetailsRepository.getRewardByCustomerId(customerId,dateBeforeThreeMonths);

		if(rewardByCustomerId.isEmpty()){
			throw new NotFoundException("Customer Id not found");
		}
		rewardByCustomerId.forEach(x -> {
			Integer reward = calculateRewards(x);
			x.setRewards(new BigDecimal(reward));
		});

		response = new Response<>();
		response.setMessage(REWARD_DETAILS_FETCHED_SUCCESSFULLY);
		response.setData(rewardByCustomerId);
		return response;
	}
}
